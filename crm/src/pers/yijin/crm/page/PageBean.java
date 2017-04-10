package pers.yijin.crm.page;

import java.util.List;

/**
 * ���ڴ�ŷ�ҳ���ݵ���
 */
public class PageBean<T> {

	private int pageNum; // �ڼ�ҳ
	private int pageSize; // ÿҳ��ʾ�ĸ���
	private int totalRecord;// �ܼ�¼��

	private int startIndex; // ��ʼ����
	private int totalPage; // �ܷ�ҳ��

	private List<T> data; // ��ѯ���ķ�ҳ���ݼ���

	// ��̬��ʾ��
	private int start;
	private int end;

	// ����һ�����������Ĺ��췽����ʹ���󱻴���ʱ�����в����Ͷ�����ֵ
	public PageBean(int pageNum, int pageSize, int totalRecord) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;

		// ���㿪ʼ����
		this.startIndex = (this.pageNum - 1) * this.pageSize;
		// �����ܷ�ҳ��
		this.totalPage = (this.totalRecord + this.pageSize - 1) / this.pageSize;

		// ��̬��ʾ���ĳ�ʼֵ
		this.start = 1;
		this.end = 10;

		// �ж��ܷ�ҳ���Ͷ�̬��ʾ�Ĺ�ϵ������ܷ�ҳ����10С����̬��ʾ�����Ϊ�ܷ�ҳ��
		if (this.totalPage <= 10) {
			this.end = this.totalPage;
		} else {
			// ����ܷ�ҳ����10����̬��ʾ��startֵӦΪ��ǰҳ��ȥ4ҳ��endֵΪ��ǰҳ����5ҳ
			this.start = this.pageNum - 4;
			this.end = this.pageNum + 5;
			// ��ǰҳΪǰ4ҳʱ�������start��ֵΪ����ʱ����start�㶨Ϊ1��endΪ10
			if (this.start < 1) {
				this.start = 1;
				this.end = 10;
			}
			// ��ǰҳΪ���5ҳ����endֵ�϶����ܷ�ҳ������ʱ��Ҫʹend�����ܷ�ҳ��
			if (this.end > this.totalPage) {
				this.end = this.totalPage;
				this.start = this.end - 9;
			}
		}
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
