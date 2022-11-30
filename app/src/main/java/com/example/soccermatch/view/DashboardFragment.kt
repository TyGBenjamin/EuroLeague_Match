package com.example.soccermatch.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.soccermatch.model.local.entity.Match
import com.example.soccermatch.ui.theme.SoccerMatchTheme
import com.example.soccermatch.util.Resource
import com.example.soccermatch.viewmodel.SoccerViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class DashboardFragment: Fragment() {
    private val viewModel by activityViewModels<SoccerViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        // requireActivity()
        return ComposeView(requireActivity()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                SoccerMatchTheme {
                    viewModel.getList()
                    Surface(modifier = Modifier.fillMaxSize()) {
                        val matches = viewModel.matchList.collectAsState().value
                        println("DRINKS ARE SHOWN AS $matches")
                        when (matches) {
                            is Resource.Error -> ErrorIndicator()
                            Resource.Loading -> ProgressIndicator()
                            is Resource.Success -> {
                                val matchList = matches.data
                                HomeScreen(
                                    matches = matchList,
                                )
                            }
                            else -> {}
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProgressIndicator() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorIndicator() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "ERROR IS RETRIEVING DATA", fontSize = 40.sp)
    }
}

@Composable
fun MatchCard(
    match: Match,
) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 20.dp,
                    start = 10.dp
                )
        ) {
            Column(modifier = Modifier.padding(start = 15.dp, end = 15.dp)) {
                Column () {
                    Text(text = match.competitionStage.competition.name, fontSize = 25.sp)
                    Row() {
                        val dateOne = ZonedDateTime.parse(match.date)
                            .withZoneSameInstant(ZoneId.of("America/New_York"))
                            .format(
                            DateTimeFormatter.ofPattern("""MMMM dd 'at' hh:mm a"""))
                        Text(text = "${match.venue.name} | $dateOne", Modifier.padding(bottom = 10.dp))
                    }
                }
                Row() {
                    Column() {

                        Text(text = match.homeTeam.name, fontSize = 20.sp, modifier = Modifier.padding(bottom = 15.dp))
                        Text(text = match.awayTeam.name, fontSize = 20.sp, modifier = Modifier.padding(bottom = 15.dp))
                    }
                    Box(modifier = Modifier.padding(5.dp), contentAlignment = Alignment.Center){
                        val dateTwo = ZonedDateTime.parse(match.date).withZoneSameInstant(ZoneId.of("America/New_York")).format(
                            DateTimeFormatter.ofPattern("""MMM dd"""))
                        Text(text = " | $dateTwo", fontSize = 30.sp)
                    }
                }
            }
        }
}

@Composable
fun HomeScreen(
    matches: List<Match>
) {
    LazyColumn(state = rememberLazyListState(), modifier = Modifier.padding(5.dp)) {
        items(items = matches) { match ->
            MatchCard(
                match = match,
            )
        }
    }
}
