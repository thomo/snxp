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
package com.neotis.admin.util;

import org.mortbay.http.HttpContext;
import org.mortbay.http.HttpServer;
import org.mortbay.jetty.Server;

import java.util.Iterator;

/**
 * Start, stop or remove a web application from the server.
 * @author Matthias L. Jugel
 * @version $Id$
 */
public class ApplicationCommand {
  private final static String CMD_APPLICATION_START = "start";
  private final static String CMD_APPLICATION_STOP = "stop";
  private final static String CMD_APPLICATION_REMOVE = "remove";

  public static void execute(String srv, String ctx, String command) {
    System.err.println("srv=" + srv + " ctx=" + ctx);
    Iterator it = Server.getHttpServers().iterator();
    while (it.hasNext()) {
      HttpServer server = (HttpServer) it.next();
      if (server.toString().equals(srv)) {
        HttpContext contexts[] = server.getContexts();
        for (int c = 0; c < contexts.length; c++) {
          HttpContext context = contexts[c];
          if (context.getContextPath().equals(ctx)) {
            try {
              if (CMD_APPLICATION_START.equals(command)) {
                context.start();
              } else if (CMD_APPLICATION_STOP.equals(command)) {
                context.stop();
              } else if (CMD_APPLICATION_REMOVE.equals(command)) {
                server.removeContext(context);
              } else {
                System.err.println("Application: unknown or illegal command: " + command);
              }
            } catch (Exception e) {
              System.err.println("Application: unable to " + command + " server=" + server + ", context=" + context);
            }
            return;
          }
        }
      }
    }
  }
}