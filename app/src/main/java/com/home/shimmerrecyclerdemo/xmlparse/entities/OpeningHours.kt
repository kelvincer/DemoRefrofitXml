package com.home.shimmerrecyclerdemo.xmlparse.entities

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "opening_hours", strict = false)
data class OpeningHours @JvmOverloads constructor(
    @field:Element(name = "open_now") @param:Element(name = "open_now") var openNow:Boolean)