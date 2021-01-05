<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.longshine.com/taglib/ls" prefix="ls"%>
<%@ taglib uri="http://www.owasp.org/index.php/Category:OWASP_Enterprise_Security_API" prefix="esapi" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="com.ls.pf.base.common.ui.taglib.utils.TagUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="issm.sp.pub.dynmgrid.commonPage.vo.CommonPageVo"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%
	List<CommonPageVo> cloumnList = (List<CommonPageVo>)request.getAttribute("cloumnList");
	String resetList = (String)request.getAttribute("resetList");
	List<String> orgList = (List<String>)request.getAttribute("orgList");
	String resultName = "";

%>

<%

String path = request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>

<html>
	
	
	<ls:head  title="动态查询页面">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9">
		<script type="text/javascript" src="../../../basecommon/tree/treeUtils.js"></script>
		
	</ls:head>
	
	
	<ls:body>

			<style>
			.ie .InputFocus input,.ie .LS-input-normal input:focus{
	border: 1px solid #BFE0D4 !important;
	box-shadow: 0px 0px 3px #BFE0D4 !important;
	}
			.ie table.tab_search {
   				 background: #f9fcfb !important;
    			 margin-bottom: 1px;
			}
			
			.ie .amber table .om-widget input {
   				
   				 background: white !important;
			}
			
			.ie input[type="button"]{
			font-size: 12px;
    		color: #004648;
    		
    		background-image: url(../../issm/sp/pub/dynmgrid/commonPage/button-mid.gif);
   			 background-position: center center;
    		border: 1px solid #00A6A1;
    		height: 20px;
    		padding-right: 3px;
    		padding-left: 4px;
    		border-radius: 0px;
			}
			.ie .om-calendar-list-wrapper .om-cal-hd {
  				  background: #BFE0D4 !important;
			}
			
			.ie .om-droplist {
				    border: 2px solid #BFE0D4 !important;
				    border-radius: 0px;
			}
			
			.ie amber table .om-state-focus input{
			border:1px solid #BFE0D4 !important;
			box-shadow:0px 0px 3px #BFE0D4 !important;
			}
			
			.ie .om-calendar-list-wrapper .om-cal-box {
			    padding-bottom: 3px;
			    float: left;
			    _padding-bottom: 3px;
			    position: relative;
			    width: 206px;
			    border-radius: 3px 3px 3px 3px;
			    background: #BFE0D4;
			    padding: 0px;
			    border: 3px solid #BFE0D4;
			}
			.ie .buttonHover{
					background-image: url(../../issm/sp/pub/dynmgrid/commonPage/button-mid.gif) !important;
			}
			.ie .ui-th-ltr, .ui-jqgrid .ui-jqgrid-htable th.ui-th-ltr{
				    background-color: #E7F8F2 !important;
				    border: 1px solid;
				    border-color: ButtonHighlight #BFE0D4 #BFE0D4 ButtonHighlight;
				    color: #006D69;
			}	
			
			
			</style>

		<ls:form name="commonSelectForm" id="commonSelectForm">
			<ls:text   name="pageCode" property="pageCode" type="hidden" ></ls:text>
			<ls:text   name="isQuery" property="isQuery" type="hidden" ></ls:text>
			<!--//2020-11-11增加，从主题维护进入展示的类型 -->
			<ls:text type="hidden" name="themeMainType"   property="themeMainType"></ls:text>
			<table class="tab_search" id="content">
				<% int k=1;
				   boolean haveInPara = false;
					for(int i=0;i<cloumnList.size();i++){
						if(k==1){
				%>
						<tr>	
				<% 
						}
						CommonPageVo vo = cloumnList.get(i);
						String listName = vo.getListName();
						String listViewName = vo.getListViewName();
						String attrType = vo.getAttrType();
						//String multiFlag = vo.getMultiFlag();
						
						
						//boolean flag = false;
						//if("1".equals(multiFlag)){
						//	flag = true;
						//}
						//System.out.println("flag"+flag);
						resultName = vo.getResultName();
						String paraListName = "paraList" + String.valueOf(i);
						haveInPara = true;
						String multiFlag=paraListName+"multiFlag";
						multiFlag = (String)request.getAttribute(multiFlag);
                         
						if("0102".equals(attrType) || "0103".equals(attrType) || "0104".equals(attrType)){
							String listNameName = listName +"Name";
							String selOrgFunc = "selOrg" + listName;
							//System.out.println(selOrgFunc);
				%>
							<td width="8%"><ls:label text="<%=listViewName %>" needColon="true" ></ls:label></td>
							<td width="25%"><ls:text   name="<%=listName %>" property="<%=listName %>" type="hidden" ></ls:text>
							<ls:text   name="<%=listNameName %>" readOnly="true" property="<%=listNameName %>" imageKey="organ" onClickImage="<%=selOrgFunc %>"></ls:text></td>	
				<%			
						}else if("04".equals(attrType)){
							String codeType = vo.getCodeType();
				%>
							<td width="8%"><ls:label text="<%=listViewName %>" needColon="true"></ls:label></td>
							<td width="25%"><ls:date id="<%=listName %>" name="<%=listName %>" property="<%=listName %>" format="<%=codeType %>" /></td>	
				<%			
						}else if("0101".equals(attrType)){
							String listNameList= listName +"List";
							String multiFlag1=listNameList+"multiFlag";
							multiFlag1 = (String)request.getAttribute(multiFlag1);

							if("period".equals(listName)){
								if(multiFlag1.equals("true")){
				%>
							<td width="8%"><ls:label text="<%=listViewName %>" needColon="true"></ls:label></td>
							<td width="25%">
								<ls:select id="<%=listName %>" name="<%=listName %>" property="<%=listName %>" required="true" allowEditing="true" onchanged="periodChange" multiSelect="true">

									<ls:options property="<%=listNameList %>" scope="request" value="value" text="name"></ls:options>
								</ls:select>
							</td>	
			 	<%     			}else
			 					{
			 	              %>
						    	<td width="8%"><ls:label text="<%=listViewName %>" needColon="true"></ls:label></td>
								<td width="25%">
									<ls:select id="<%=listName %>" name="<%=listName %>" property="<%=listName %>" required="true" 
							  	multiSelect="false"	allowEditing="true"  onchanged="periodChange" >
										<ls:options property="<%=listNameList %>" scope="request" value="value" text="name"></ls:options>
									</ls:select>
								</td>	
					
					<% 			} 
							}else{
								if(multiFlag1.equals("true")){
				%>
							<td width="8%"><ls:label text="<%=listViewName %>" needColon="true"></ls:label></td>
							<td width="25%">
								<ls:select id="<%=listName %>" name="<%=listName %>" property="<%=listName %>" required="true" allowEditing="true" multiSelect="true">

									<ls:options property="<%=listNameList%>" scope="request" value="value" text="name"></ls:options>
								</ls:select>
							</td>	
				<% 
								}else{				%>
									<td width="8%"><ls:label text="<%=listViewName %>" needColon="true"></ls:label></td>
							<td width="25%">
								<ls:select id="<%=listName %>" name="<%=listName %>" 
									multiSelect="false" property="<%=listName %>" required="true" allowEditing="true">
									<ls:options property="<%=listNameList%>" scope="request" value="value" text="name"></ls:options>
								</ls:select>
							</td>		
									
						<%		}	}
						}else if("01".equals(attrType) || "06".equals(attrType)){
							if(multiFlag.equals("true")){
				%>
							<td width="8%"><ls:label text="<%=listViewName %>" needColon="true"></ls:label></td>
							<td width="25%">
								<ls:select id="<%=listName %>" name="<%=listName %>" property="<%=listName %>" required="true" allowEditing="true"
								multiSelect="true">
									<ls:options property="<%=paraListName %>" scope="request" value="value" text="name" ></ls:options>
								</ls:select>
							</td>	
				<% 
							}else{%>
									<td width="8%"><ls:label text="<%=listViewName %>" needColon="true"></ls:label></td>
							<td width="25%">
								<ls:select id="<%=listName %>" name="<%=listName %>" property="<%=listName %>" required="true" allowEditing="true"
								multiSelect="false">
									<ls:options property="<%=paraListName %>" scope="request" value="value" text="name" ></ls:options>
								</ls:select>
							</td>	
								
								
					<% 		}
						}
						else{
				%>
							<td width="8%"><ls:label text="<%=listViewName %>" needColon="true"></ls:label></td>
							<td width="25%"><ls:text name="<%=listName %>"  property="<%=listName %>" type="text" ></ls:text></td>		
				<%		
						}
						if(k==3){
							k=0;
				%>
							<td></td></tr>	
				<% 
						}
						k++;
					}
					if( k != 1){
						for(int j=k;j<4;j++){
							if(j==3){
				%>
								<td width="8%" ></td><td width="15%">
									<div class="pull-right">
										<ls:button text="重置" name="reset" onclick="doReset"></ls:button>
										<ls:button text="查询" name="query" onclick="doQuery"></ls:button>
									</div>
								</td><td></td></tr>
				<%
							}else{
				%>
								<td width="8%"></td> <td width="15%"></td>	
				<%				
							}
						}
					}else if(haveInPara){
				%>
						<tr>
							<td width="8%">
							<td width="15%">
							</td>
							<td width="8%">
							</td>
							<td width="15%">
							</td>
							<td width="8%">
							</td>
							<td width="15%">
								<div class="pull-right">
								    <ls:button text="重置" name="reset" onclick="doReset"></ls:button>
									<ls:button text="查询" name="query" onclick="doQuery"></ls:button>
								</div>
							</td>
							<td></td>
						</tr>
				<%		
					}
				else{
				%>
						<tr>
							<td width="8%">
							<td width="15%">
							</td>
							<td width="8%">
							</td>
							<td width="15%">
							</td>
							<td width="8%">
							</td>
							<td width="15%">
								<div class="pull-right">
									<ls:button text="查询" name="query" onclick="doQuery"></ls:button>
								</div>
							</td>
							<td></td>
						</tr>
				<%		
					}
				%>
			</table>
			<ls:title text="<%=resultName %>" expand="true">
				<div style="height: 400px;width: 98%;padding-left: 1%;">
					<iframe id="gridFrame" name="gridFrame" height="400px;" width="100%" src="" frameborder=0 ></iframe>
				</div>
			</ls:title>
		</ls:form>
		<ls:script>
		var ms_ie = false;
var ua = window.navigator.userAgent;
var old_ie = ua.indexOf('MSIE ');
var new_ie = ua.indexOf('Trident/');
    
if ((old_ie > -1) || (new_ie > -1)) {
    ms_ie = true;
    
}
    
if ( ms_ie ) {
   document.documentElement.className += " ie";
}

			window.getParams = getParams;
			window.getParams2 = getParams2;
			<% 
				for(int i=0;i<orgList.size();i++){
					String orgFun = orgList.get(i);
					//System.out.println(orgFun);
			%>	
				<%=orgFun %>
			<%
				}
			%>
			function periodChange(){
				debugger;
				if(period.value=='03'){
					statCycle.changeDateType("yyyy-MM");
				}else if(period.value == '02'){
					statCycle.changeDateType("yyyy-MM-dd");
				}else{
					statCycle.changeDateType("yyyy");
				}
			}
			//doQuery();
			<%--查询方法 --%>
			function doQuery(){
				var params = commonSelectForm.getFormData();
				params.gridHeight= "450px";
				console.log("commonPage2.doQuery().params",params);
				paramstr = encodeURI(encodeURI(JSON.stringify(params)));
				var gridUrl= "<%=ESAPI.encoder().encodeForJavaScript(request.getContextPath())%>/commonPage/initGrid2?params="+paramstr;
				document.getElementById("gridFrame").src = gridUrl;
				isQuery.setValue("1");
				
				
							
				
			}
			<%--重置方法 --%>
			function doReset(){
				getPageSizeIndex1();
				var list = eval('<%=ESAPI.encoder().encodeForJavaScript(resetList) %>');
				var fields = commonSelectForm.fields;
				//for(var i = 0; i < list.length; i++){
					//var objMap = list[i];
					//var objName = objMap.name;
					//var objValue = objMap.value;
					//var obj = eval('(' + objName + ')');
					//obj.setValue(objValue);
				//}
				for (var name in fields) {
					if(name != 'pageCode'){
						var field = fields[name];
						if (field && field.setValue) {
							field.setValue("");
						}
					}
				}
			}
			<%--获取params参数 --%>
			function getParams(){
				var params = commonSelectForm.getFormData();
				params.gridHeight= "450px";
				paramstr = encodeURI(encodeURI(JSON.stringify(params)));
				return paramstr;
			}
			function getParams2(){
				var params = window.frames['gridFrame'].getParams1();
				return params;
			}
			
			<!-- 现场刘川 2018-8-21 增加 -->
			window.getCommonPage2ListSize = getCommonPage2ListSize;
			function getCommonPage2ListSize(){
			  var listSize = document.getElementById('gridFrame').contentWindow.getCommonGrid2ListSize();
			  return listSize;
			}
			window.getQueryStatusCode = getQueryStatusCode;
			function getQueryStatusCode(){
			  var statusCode = isQuery.getValue();
			  return statusCode;
			}
			
			window.getItems=getItems;
			function getItems(){
				var rows = document.getElementById('gridFrame').contentWindow.getItems();
			  	return rows;
			}
			
			window.transQueryNum=transQueryNum;
			function transQueryNum(){
			 var queryNum = document.getElementById('gridFrame').contentWindow.transQueryNum();
			  	return queryNum;
			}
			
			function getPageSizeIndex1(){
			 var pageSizeIndex1 = document.getElementById('gridFrame').contentWindow.getPageSizeIndex1();
			  	return pageSizeIndex1;
			}
		</ls:script>
	</ls:body>
</html>