package com.example.home_widget_counter

import HomeWidgetGlanceState
import HomeWidgetGlanceStateDefinition
import android.content.Context

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.glance.GlanceId
import androidx.glance.GlanceModifier

import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget

import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column

import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize

import androidx.glance.layout.padding

import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextAlign
import androidx.glance.text.TextStyle
import es.antonborri.home_widget.actionStartActivity


class CounterGlanceWidget : GlanceAppWidget() {


  override val stateDefinition = HomeWidgetGlanceStateDefinition()

  override suspend fun provideGlance(context: Context, id: GlanceId) {
    provideContent {
      GlanceContent(context, currentState())
    }
  }

  @Composable
  private fun GlanceContent(context: Context, currentState: HomeWidgetGlanceState) {
    val data = currentState.preferences
    val count = data.getInt("counter", 0)

    Box(modifier = GlanceModifier
        .background(Color.White)
        .padding(16.dp)
        .clickable(onClick = actionStartActivity<MainActivity>(context))) {
      Column(
          modifier = GlanceModifier.fillMaxSize(),
          verticalAlignment = Alignment.Vertical.CenterVertically,
          horizontalAlignment = Alignment.Horizontal.CenterHorizontally,
      ) {
        Text(
            "안녕하세요 테스트 입니다.",
            style = TextStyle(fontSize = 14.sp, textAlign = TextAlign.Center),
        )
        Spacer(GlanceModifier.defaultWeight())
        Text(
            count.toString(),
            style = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center),
        )
        Spacer(GlanceModifier.defaultWeight())

      }
    }
  }
}
