package demo20171224;

import com.github.crab2died.annotation.ExcelField;

public class ElementMap {
	@ExcelField(title = "类型")
	private String type;
	@ExcelField(title = "地址")
	private String url;
	@ExcelField(title = "参数")
	private String params;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	@ExcelField(title = "头部")
	private String header;
	// @ExcelField(title="编号")
	// private int number;
	@Override
	public String toString() {
		return "ElementMap [type=" + type + ", url=" + url + ", params=" + params + ", header=" + header + "]";
	}

}
