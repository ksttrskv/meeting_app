import com.example.domain.model.Meeting
import kotlinx.coroutines.flow.Flow

interface MeetingRepository {
    fun getMeetings(): List<Meeting>
    fun getMeetingsByCommunity(communityTitle: String): Flow<List<Meeting>>
}
