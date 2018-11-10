/*******************************************************************************
 * Copyright (c) 2018 Red Hat Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat Inc - initial API and implementation
 *******************************************************************************/
package org.eclipse.packagedrone.utils.rpm.build;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Optional;

import org.eclipse.packagedrone.utils.rpm.deps.Dependency;

public class NullPayloadCoding implements PayloadCoding
{
    protected NullPayloadCoding ()
    {

    }

    @Override
    public String getCoding ()
    {
        return null;
    }

    @Override
    public Optional<Dependency> getDependency ()
    {
        return Optional.empty ();
    }

    @Override
    public InputStream createInputStream ( final InputStream in ) throws IOException
    {
        return in;
    }

    @Override
    public OutputStream createOutputStream ( final OutputStream out, final Optional<String> optionalFlags ) throws IOException
    {
        return out;
    }
}
