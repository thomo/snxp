/*
 * This file is part of "SnipSnap Wiki/Weblog".
 *
 * Copyright (c) 2002 Stephan J. Schmidt, Matthias L. Jugel
 * All Rights Reserved.
 *
 * Please visit http://snipsnap.org/ for updates and contact.
 *
 * --LICENSE NOTICE--
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 * --LICENSE NOTICE--
 */
/*
 * Macro that replaces external links
 *
 * @author stephan
 * @team sonicteam
 * @version $Id$
 */

package org.snipsnap.snip.filter.macro;

import org.snipsnap.snip.Snip;
import org.snipsnap.snip.filter.Filter;
import org.snipsnap.snip.filter.JavaCodeFilter;
import org.snipsnap.snip.filter.SqlCodeFilter;
import org.snipsnap.snip.filter.XmlCodeFilter;
import org.python.util.PythonInterpreter;
import org.python.core.PyObject;

import java.util.HashMap;
import java.util.Map;
import java.io.StringWriter;
import java.io.IOException;
import java.io.Writer;

public class ScriptMacro extends Preserved {
  private Map filters;

  public ScriptMacro() {
  }

  public String getName() {
    return "script";
  }

  public void execute(Writer writer, String[] params, String content, Snip snip)
      throws IllegalArgumentException, IOException {

     PythonInterpreter interp =
	    new PythonInterpreter();

    interp.setOut(writer);
    interp.set("snip", snip);
    interp.exec(content);
  }
}
