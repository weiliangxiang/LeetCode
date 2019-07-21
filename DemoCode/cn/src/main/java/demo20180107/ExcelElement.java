package demo20180107;

import com.github.crab2died.annotation.ExcelField;

public class ExcelElement {
	@ExcelField(title = "类型")
	private String type;
	@ExcelField(title = "地址")
	private String url;
	@ExcelField(title = "参数")
	private String params;
	@ExcelField(title = "头部")
	private String header;
	@ExcelField(title = "开启")
	private String run;
	@ExcelField(title = "检查点")
	private String check;
	@ExcelField(title = "关联")
	private String correction;
	@ExcelField(title = "测试结果")
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getCorrection() {
		return correction;
	}

	public void setCorrection(String correction) {
		this.correction = correction;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

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

	@Override
	public String toString() {
		return "ExcelElement [type=" + type + ", url=" + url + ", params=" + params + ", header=" + header + ", run="
				+ run + ", check=" + check + ", correction=" + correction + ", result=" + result + ", getResult()="
				+ getResult() + ", getCheck()=" + getCheck() + ", getCorrection()=" + getCorrection() + ", getRun()="
				+ getRun() + ", getType()=" + getType() + ", getUrl()=" + getUrl() + ", getParams()=" + getParams()
				+ ", getHeader()=" + getHeader() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	

}
