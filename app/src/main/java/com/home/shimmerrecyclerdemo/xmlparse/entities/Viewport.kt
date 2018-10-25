package com.home.shimmerrecyclerdemo.xmlparse.entities

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "viewport", strict = false)
data class Viewport  @JvmOverloads constructor(
    @field:Element(name = "northeast")  @param:Element(name = "northeast") var northeast: Northeast,
    @field:Element(name = "southwest")  @param:Element(name = "southwest") var southwest: Northeast
)