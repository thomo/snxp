/*
 * Abstract Filter Class that supplies the
 * Filter interface. Concrete Filters should
 * inherit from Filter
 *
 * @author stephan
 * @team sonicteam
 * @version $Id$
 */
package com.neotis.snip.filter;

import com.neotis.snip.Snip;

public abstract class Filter {

  public Filter() {
  }

  public abstract String filter(String input, Snip snip);
}