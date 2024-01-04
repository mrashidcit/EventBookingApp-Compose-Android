package com.rashidsaleem.eventbookingapp.domain.models.home

import com.rashidsaleem.eventbookingapp.R
import java.util.Calendar
import java.util.Date

data class EventModel(
    val date: Date? = null,
    val title: String = "",
    val goingPersons: List<Int> = listOf<Int>(),
    val address: String = "",
) {

    fun getFirst3Persons() = if (goingPersons.size <= 3)
        goingPersons
    else
        goingPersons.subList(0, 3)

    fun getPersonsOtherThanFirst3Persons(): List<Int> {
        val first3Persons = getFirst3Persons()
        if (goingPersons.isEmpty()) return listOf()
        if (first3Persons.size == goingPersons.size) return listOf()
        return goingPersons.subList(first3Persons.size, goingPersons.size)
    }

    fun plusGoingPersonsLabel(): String {
        val personsOtherThanFirst3Persons = getPersonsOtherThanFirst3Persons()
        if (personsOtherThanFirst3Persons.isEmpty()) return ""
        return "+${personsOtherThanFirst3Persons.size} Going"
    }

    companion object {
        fun dummyEvents() = arrayListOf<EventModel>(
            EventModel(
                date = Calendar.getInstance().apply {
                    this.set(Calendar.DAY_OF_MONTH, 1)
                }.time,
                title = "Internation Brand Mu......",
                goingPersons = listOf(
                    R.drawable.img_going_1,
                    R.drawable.img_going_2,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                ),
                address = "36 Guild Street London, UK"
            ),
            EventModel(
                date = Calendar.getInstance().apply {
                    this.set(Calendar.DAY_OF_MONTH, 1)
                }.time,
                title = "Jo Malone London's Mo.....",
                goingPersons = listOf(
                    R.drawable.img_going_1,
                    R.drawable.img_going_2,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                ),
                address = "Radius Gallery.Santa Cruz, CA"
            ),
            EventModel(
                date = Calendar.getInstance().apply {
                    this.set(Calendar.DAY_OF_MONTH, 1)
                }.time,
                title = "Internation Brand Mu......",
                goingPersons = listOf(
                    R.drawable.img_going_1,
                    R.drawable.img_going_2,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                ),
                address = "36 Guild Street London, UK"
            ),
            EventModel(
                date = Calendar.getInstance().apply {
                    this.set(Calendar.DAY_OF_MONTH, 1)
                }.time,
                title = "Internation Brand Mu......",
                goingPersons = listOf(
                    R.drawable.img_going_1,
                    R.drawable.img_going_2,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                ),
                address = "36 Guild Street London, UK"
            ),
            EventModel(
                date = Calendar.getInstance().apply {
                    this.set(Calendar.DAY_OF_MONTH, 1)
                }.time,
                title = "Internation Brand Mu......",
                goingPersons = listOf(
                    R.drawable.img_going_1,
                    R.drawable.img_going_2,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                    R.drawable.img_going_3,
                ),
                address = "36 Guild Street London, UK"
            ),

            )
    }

}
