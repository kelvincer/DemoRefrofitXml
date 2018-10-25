package com.home.shimmerrecyclerdemo.xmlparse.entities

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "geometry", strict = false)
data class Geometry @JvmOverloads constructor(
    @field:Element(name = "location") @param:Element(name = "location") var location: Location,
    @field:Element(name = "viewport") @param:Element(name = "viewport") var viewport: Viewport
)