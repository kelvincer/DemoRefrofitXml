package com.home.shimmerrecyclerdemo.xmlparse.entities

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "northeast", strict = false)
data class Northeast @JvmOverloads constructor(
    @field:Element(name = "lat") @param:Element(name = "lat") var lat: Double,
    @field:Element(name = "lng") @param:Element(name = "lng") var lng: Double
)