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

package org.snipsnap.render.macro;

import org.snipsnap.render.filter.interwiki.InterWiki;
import org.snipsnap.snip.Snip;
import org.snipsnap.snip.SnipSpaceFactory;
import org.snipsnap.snip.Modified;
import org.radeox.macro.parameter.MacroParameter;
import org.radeox.macro.Macro;

import java.io.IOException;
import java.io.Writer;

/*
 * Macro that displays how long the SnipSnap is online (installed)
 *
 * @author stephan
 * @team sonicteam
 * @version $Id$
 */

public class OnlineTimeMacro extends Macro {
    private String[] paramDescription =
     {"none"};

  public String[] getParamDescription() {
    return paramDescription;
  }
  public String getName() {
    return "online-time";
  }

  public String getDescription() {
    return "Displays the time since SnipSnap is online.";
  }

  public void execute(Writer writer, MacroParameter params)
      throws IllegalArgumentException, IOException {

    Snip snip = SnipSpaceFactory.getInstance().load("start");
    writer.write(Modified.getNiceTime(snip.getModified().getcTime()));
    return;
  }
}