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

package org.snipsnap.render.macro.parameter;

import org.snipsnap.app.Application;
import org.snipsnap.snip.Snip;
import org.radeox.util.logging.Logger;
import org.radeox.macro.parameter.BaseMacroParameter;
import org.radeox.macro.parameter.MacroParameter;
import org.radeox.filter.context.FilterContext;
import org.radeox.engine.context.RenderContext;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Encapsulates parameters for an execute Macro call.
 * This extends MacroParameter for usage in a SnipSnap
 * enviroment. For example SnipMacroParameter contains
 * a getSnip() method to get the current Snip
 *
 * @author Stephan J. Schmidt
 * @version $Id$
 */

public class SnipMacroParameter extends BaseMacroParameter  {
  private Snip snip;

  public SnipMacroParameter(Snip snip, RenderContext context) {
    params = new HashMap();
    this.context = context;
    this.snip = snip;
  }

  public SnipMacroParameter(String stringParams) {
    setParams(stringParams);
  }

  /**
   * Gets the current snip from which the macro was called.
   *
   * @return snip Snip from which the macro was called
   */
  public Snip getSnip() {
    return snip;
  }


}