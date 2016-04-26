/*******************************************************************************
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.packagedrone.web.forms.tags;

import static org.eclipse.packagedrone.web.forms.tags.Helper.makeString;

import java.util.Collection;
import java.util.Collections;

import javax.servlet.jsp.JspException;

public class OptionList extends OptionTagSupport
{
    private static final long serialVersionUID = 1L;

    private Collection<?> items = Collections.emptyList ();

    /**
     * Path to the item value
     */
    private String itemValue;

    @Override
    public int doStartTag () throws JspException
    {
        final WriterHelper writer = new WriterHelper ( this.pageContext );

        if ( this.items != null )
        {
            for ( final Object o : this.items )
            {
                renderOption ( writer, o );
            }
        }

        return SKIP_BODY;
    }

    protected void renderOption ( final WriterHelper writer, final Object o ) throws JspException
    {
        renderOption ( writer, makeString ( o, this.itemValue ), o, false );
    }

    protected void renderOption ( final WriterHelper writer, final Object value, final Object label, final boolean selected ) throws JspException
    {
        writer.write ( "<option" );
        writer.writeAttribute ( "value", value );
        writer.writeFlagAttribute ( "selected", isSelected ( value ) );
        writer.write ( " >" );

        writer.writeEscaped ( label != null ? "" + label : "" + value );

        writer.write ( "</option>" );
    }

    public void setItems ( final Collection<?> items )
    {
        this.items = items;
    }

    public void setItemValue ( final String itemValue )
    {
        this.itemValue = itemValue;
    }
}
