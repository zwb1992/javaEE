package org.apache.jsp.WEB_002dINF.jsps;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class course_005foverview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>我不是真正的慕课网</title>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.print(request.getContextPath());
      out.write("/resources/css/main.css\"\r\n");
      out.write("\ttype=\"text/css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"main\">\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"newcontainer\" id=\"course_intro\">\r\n");
      out.write("\t\t\t<div class=\"course-title\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${course.title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</div>\r\n");
      out.write("\t\t\t<div class=\"course_info\">\r\n");
      out.write("\t\t\t\t<div class=\"course-embed l\">\r\n");
      out.write("\t\t\t\t\t<div id=\"js-course-img\" class=\"img-wrap\">\r\n");
      out.write("\t\t\t\t\t\t<img width=\"600\" height=\"340\" alt=\"\"\r\n");
      out.write("\t\t\t\t\t\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${course.imgPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"course_video\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div id=\"js-video-wrap\" class=\"video\" style=\"display: none\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"video_box\" id=\"js-video\"></div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"course_state\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><span>学习人数</span> <em>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${course.learningNum }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</em></li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"course_hour\"><span>课程时长</span> <em\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"ft-adjust\"><span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${course.duration }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>秒</em></li>\r\n");
      out.write("\t\t\t\t\t\t<li><span>课程难度</span> <em>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${course.levelDesc }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</em></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("<!--  \r\n");
      out.write("\t\t\t\t<div class=\"course_intro\">\r\n");
      out.write("\t\t\t\t\t<div class=\"concerned_course add_concerned_course\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0)\" data-id=\"202\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"btn-add-follow js-btn-follow\"> <i></i> <em\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"concerned-icon\">关注此课程</em>\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"curse_btn\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\">开始学习</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t-->\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"course_list\">\r\n");
      out.write("\t\t\t\t<div class=\"outline\">\r\n");
      out.write("\t\t\t\t\t<h3 class=\"chapter_introduces\">课程介绍</h3>\r\n");
      out.write("\t\t\t\t\t<div class=\"course_shortdecription\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${course.descr}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<h3 class=\"chapter_catalog\">课程提纲</h3>\r\n");
      out.write("\t\t\t\t\t<ul id=\"couList\">\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/jsps/course_overview.jsp(60,6) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsps/course_overview.jsp(60,6) '${course.chapterList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${course.chapterList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/jsps/course_overview.jsp(60,6) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("chapter");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t<li class=\"clearfix open\"><a href=\"#\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"openicon\"></div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"outline_list l\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<!-- <em class=\"outline_zt\"></em> -->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<h5 class=\"outline_name\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${chapter.title }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</h5>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<p class=\"outline_descr\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${chapter.descr }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</p>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t</a></li>\r\n");
          out.write("\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
