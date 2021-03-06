/*******************************************************************************
 * Copyright (c) 2015 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.packagedrone.repo.adapter.p2.internal.aspect;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.packagedrone.utils.io.IOConsumer;

@FunctionalInterface
public interface ArtifactStreamer
{
    public void stream ( String artifactId, IOConsumer<InputStream> receiver ) throws IOException;
}
