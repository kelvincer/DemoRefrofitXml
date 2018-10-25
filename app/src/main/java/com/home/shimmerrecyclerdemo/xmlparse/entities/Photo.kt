package com.home.shimmerrecyclerdemo.xmlparse.entities

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "photo", strict = false)
data class Photo @JvmOverloads constructor(
    @field:Element(name = "height") @param:Element(name = "height") var height: Int,
    @field:Element(name = "width") @param:Element(name = "width") var width: Int,
   // @field:ElementList(inline = true, name = "html_attributions") @param:ElementList(name = "html_attributions") var htmlAttributions: List<String>,
    @field:Element(name = "photo_reference") @param:Element(name = "photo_reference") var photoReference: String
)