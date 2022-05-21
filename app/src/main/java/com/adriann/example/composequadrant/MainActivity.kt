package com.adriann.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adriann.example.composequadrant.ui.theme.ComposeQuadrantTheme

data class CellData(
    val title: String,
    val description: String
)

data class QuadrantData(
    val topLeft: CellData,
    val topRight: CellData,
    val bottomLeft: CellData,
    val bottomRight: CellData
)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val demoData = QuadrantData(
                topLeft = CellData(
                    stringResource(R.string.title1),
                    stringResource(R.string.description1)
                ),
                topRight = CellData(
                    stringResource(R.string.title2),
                    stringResource(R.string.description2)
                ),
                bottomLeft = CellData(
                    stringResource(R.string.title3),
                    stringResource(R.string.description3)
                ),
                bottomRight = CellData(
                    stringResource(R.string.title4),
                    stringResource(R.string.description4)
                )
            )
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Quadrant(data = demoData)
                }
            }
        }
    }
}

@Composable
fun Quadrant(data: QuadrantData) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.weight(1f)) {
            Cell(
                data = data.topLeft,
                backgroundColor = Color.Green,
                modifier = Modifier.weight(1f)
            )
            Cell(
                data = data.topRight,
                backgroundColor = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            Cell(
                data = data.bottomLeft,
                backgroundColor = Color.Cyan,
                modifier = Modifier.weight(1f)
            )
            Cell(
                data = data.bottomRight,
                backgroundColor = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun Cell(
    data: CellData,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = data.title, fontWeight = FontWeight.Bold)
        Text(text = data.description, textAlign = TextAlign.Justify)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    val demoData = QuadrantData(
        topLeft = CellData(
            stringResource(R.string.title1),
            stringResource(R.string.description1)
        ),
        topRight = CellData(
            stringResource(R.string.title2),
            stringResource(R.string.description2)
        ),
        bottomLeft = CellData(
            stringResource(R.string.title3),
            stringResource(R.string.description3)
        ),
        bottomRight = CellData(
            stringResource(R.string.title4),
            stringResource(R.string.description4)
        )
    )
    ComposeQuadrantTheme {
        Quadrant(data = demoData)
    }
}
