package com.example.composelearners

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelearners.ui.theme.ComposeLearnersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearnersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                    content = { LearnerCard(Learner("Kennedy"))}
                )
            }
        }
    }
}

data class Learner(val name: String)

@Composable
fun LearnerCard(learner: Learner) {

    Column {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Learner Name",
        )

        Spacer(modifier = Modifier.fillMaxSize())

        Row {
            Surface(shape = MaterialTheme.shapes.large, elevation = 5.dp) {

                Text(
                    text = learner.name, color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LearnersGrid(learners: List<Learner>) {
    LazyVerticalGrid(cells = GridCells.Fixed(2),
        Modifier.padding(20.dp)) {
        items(learners) { learner ->
            LearnerCard(learner)
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode")
@Composable
fun DefaultPreview() {
    ComposeLearnersTheme {
        LearnersGrid(
            listOf(Learner("Kennedy"), Learner("Zendaya"), Learner("Krste"),
                Learner("Felix"), Learner("Fabian"), Learner("Logan"),
                Learner("Swanson"), Learner("Merlin"), Learner("Brie"),
                Learner("Max"), Learner("Aidan"))
        )
    }
}