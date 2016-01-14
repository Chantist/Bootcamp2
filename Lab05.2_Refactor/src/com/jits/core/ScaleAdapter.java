package com.jits.core;

import com.thirdParty.calibration.MailScale;

class ScaleAdapter
{
  private MailScale scale = new MailScale();

  double weighPackage(Package pkg)
  {
    // get actual weight and round up to next whole ounce
    return Math.ceil(scale.calculateWeight(pkg));
  }
}