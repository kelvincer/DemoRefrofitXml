package com.home.shimmerrecyclerdemo.xmlparse.entities

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "result", strict = false)
data class Result @JvmOverloads constructor(
    @field:Element(name = "geometry") @param:Element(name = "geometry") var geometry: Geometry,
    @field:Element(name = "icon") @param:Element(name = "icon") var icon: String,
    @field:Element(name = "id") @param:Element(name = "id") var id: String,
    @field:Element(name = "name") @param:Element(name = "name") var name: String,
    @field:Element(name = "opening_hours") @param:Element(name = "opening_hours") var openingHours: OpeningHours,
    @field:Element(name = "photo") @param:Element(name = "photo") var photo: Photo?,
    @field:Element(name = "place_id") @param:Element(name = "place_id") var placeId: String,
    @field:Element(name = "rating") @param:Element(name = "rating") var rating: Double?,
    @field:Element(name = "reference") @param:Element(name = "reference") var reference: String,
    @field:ElementList(inline = true, name = "type", required = false) @param:ElementList(
        name = "type",
        required = false,
        inline = true
    ) var type: MutableList<String>?,
    @field:Element(name = "vicinity", required = false) @param:Element(name = "vicinity") var vicinity: String?
    )