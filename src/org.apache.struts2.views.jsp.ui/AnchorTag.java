//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.apache.struts2.views.jsp.ui;

import com.ezra.gechuang.domain.User;
import com.opensymphony.xwork2.util.ValueStack;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.BooleanUtils;
import javax.servlet.jsp.JspException;
import org.apache.struts2.components.Anchor;
import org.apache.struts2.components.Component;

public class AnchorTag extends AbstractClosingTag {
    private static final long serialVersionUID = -1034616578492431113L;
    protected String href;
    protected String includeParams;
    protected String scheme;
    protected String action;
    protected String namespace;
    protected String method;
    protected String encode;
    protected String includeContext;
    protected String escapeAmp;
    protected String portletMode;
    protected String windowState;
    protected String portletUrlType;
    protected String anchor;
    protected String forceAddSchemeHostAndPort;

    public AnchorTag() {
    }

    @Override
    public int doEndTag() throws JspException {
        User currentUser = (User) pageContext.getSession().getAttribute("currentUser");

        // 去掉当前url的参数
        String privilegeUrl = action;
        int pos = privilegeUrl.indexOf("?");
        if (pos > -1){
            privilegeUrl = privilegeUrl.substring(0, pos);
        }

        if (currentUser.hasPrivilegeByUrl(privilegeUrl)){
            return super.doEndTag();
        } else {
            return EVAL_PAGE;//表示若没有权限，则不显示当前标签，继续执行后面的代码
        }
    }

    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new Anchor(stack, req, res);
    }

    protected void populateParams() {
        super.populateParams();
        Anchor tag = (Anchor)this.component;
        tag.setHref(this.href);
        tag.setIncludeParams(this.includeParams);
        tag.setScheme(this.scheme);
        tag.setValue(this.value);
        tag.setMethod(this.method);
        tag.setNamespace(this.namespace);
        tag.setAction(this.action);
        tag.setPortletMode(this.portletMode);
        tag.setPortletUrlType(this.portletUrlType);
        tag.setWindowState(this.windowState);
        tag.setAnchor(this.anchor);
        if (this.encode != null) {
            tag.setEncode(BooleanUtils.toBoolean(this.encode));
        }

        if (this.includeContext != null) {
            tag.setIncludeContext(BooleanUtils.toBoolean(this.includeContext));
        }

        if (this.escapeAmp != null) {
            tag.setEscapeAmp(BooleanUtils.toBoolean(this.escapeAmp));
        }

        if (this.forceAddSchemeHostAndPort != null) {
            tag.setForceAddSchemeHostAndPort(BooleanUtils.toBoolean(this.forceAddSchemeHostAndPort));
        }

    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

    public void setIncludeContext(String includeContext) {
        this.includeContext = includeContext;
    }

    public void setEscapeAmp(String escapeAmp) {
        this.escapeAmp = escapeAmp;
    }

    public void setIncludeParams(String name) {
        this.includeParams = name;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setPortletMode(String portletMode) {
        this.portletMode = portletMode;
    }

    public void setPortletUrlType(String portletUrlType) {
        this.portletUrlType = portletUrlType;
    }

    public void setWindowState(String windowState) {
        this.windowState = windowState;
    }

    public void setAnchor(String anchor) {
        this.anchor = anchor;
    }

    public void setForceAddSchemeHostAndPort(String forceAddSchemeHostAndPort) {
        this.forceAddSchemeHostAndPort = forceAddSchemeHostAndPort;
    }
}
