// Copyright (c) 2003-2014, Jodd Team (jodd.org). All Rights Reserved.

package jodd.servlet.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Else nested tag for {@link jodd.servlet.tag.IfElseTag}.
 */
public class ElseTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException {
		JspTag parent = getParent();
		if (parent == null || !(parent instanceof IfElseTag)) {
			throw new JspException("Parent IfElse tag is required", null);
		}

		IfElseTag ifTag = (IfElseTag) parent;
		if (ifTag.getTestValue() == false) {
			TagUtil.invokeBody(getJspBody());
		}
	}
}