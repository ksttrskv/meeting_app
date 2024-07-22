import com.example.domain.model.Meeting

interface MeetingRepository {
    fun getMeetings(): List<Meeting>
}
