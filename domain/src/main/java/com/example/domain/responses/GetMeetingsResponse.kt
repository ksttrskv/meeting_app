package com.example.domain.responses

import com.example.domain.model.Meeting

data class GetMeetingsResponse(
    val data: List<Meeting>,
)