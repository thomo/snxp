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
package com.neotis.util;

import com.neotis.snip.Snip;

import java.util.LinkedList;
import java.util.List;

/**
 * Queue implementation for Snips.
 * @author Stephan J. Schmidt
 * @version $Id$
 */
public class Queue {
  private LinkedList queue;
  private int size;

  public Queue(int size) {
    this.size = size;
    queue = new LinkedList();
  }

  public void fill(List list) {
    queue.clear();
    queue.addAll(list);
  }

  public Snip add(Snip snip) {
    if (queue.contains(snip)) {
      queue.remove(snip);
    }

    if (queue.size() == size) {
      queue.removeLast();
    }
    queue.addFirst(snip);
    return snip;
  }

  public void remove(Snip snip) {
    queue.remove(snip);
  }

  public List get() {
    return (List) queue;
  }

  public List get(int count) {
    count = Math.min(count-1, queue.size());
    return (List) queue.subList(0, count-1);
  }
}
