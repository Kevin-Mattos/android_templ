package com.example.coreui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


val ShimmerColorShades = listOf(

	Color.LightGray.copy(0.9f),

	Color.LightGray.copy(0.2f),

	Color.LightGray.copy(0.9f)

)

@Composable
fun ShimmerAnimation(
	 shimmerItem: @Composable (brush: Brush) -> Unit
) {
	val transition = rememberInfiniteTransition()
	val translateAnim by transition.animateFloat(
		initialValue = 0f,
		targetValue = 1000f,
		animationSpec = infiniteRepeatable(
			tween(durationMillis = 1200, easing = FastOutSlowInEasing),
			RepeatMode.Reverse
		)
	)
	val brush = Brush.linearGradient(
		colors = ShimmerColorShades,
		start = Offset(10f, 10f),
		end = Offset(translateAnim, translateAnim)
	)

	shimmerItem(brush = brush)
}

@Composable
fun ShimmerItemRow(brush: Brush, modifier: Modifier = Modifier) {
	ShimmerItem(brush = brush, modifier.height(64.dp))
}

@Composable
fun ShimmerItem(
	brush: Brush,
	modifier: Modifier = Modifier
) {
	Spacer(
		modifier = modifier
			.fillMaxWidth()
			.padding(12.dp)
			.background(brush = brush)
	)
}