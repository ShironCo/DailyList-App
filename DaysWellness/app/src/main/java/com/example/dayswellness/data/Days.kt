package com.example.dayswellness.data

import androidx.annotation.DrawableRes
import com.example.dayswellness.R

data class Days(
    val descripcionDay: String,
    @DrawableRes val imgRes: Int
)

object DaysRepository{
    val days = listOf(
        Days(
            descripcionDay = "Despierta temprano para comenzar el día con energía y motivación.",
            imgRes = R.drawable
        ),
        Days(
            descripcionDay = "Haz estiramientos o yoga al despertar para activar tu cuerpo.",
            imgRes = R.drawable
        ),
        Days(
            descripcionDay = "Dedica unos minutos a meditar para reducir el estrés y mejorar tu salud mental.",
            imgRes = R.drawable
        ),
        Days(
            descripcionDay = "Planifica tus tareas y prioridades para aumentar tu productividad.",
            imgRes = R.drawable
        ),
        Days(
            descripcionDay = "Toma descansos regulares durante el día para evitar la fatiga mental y física.",
            imgRes = R.drawable
        ),
        Days(
            descripcionDay = "Aprende algo nuevo cada día para crecer personalmente y profesionalmente.",
            imgRes = R.drawable
        ),
        Days(
            descripcionDay = "Haz una lista de metas a corto y largo plazo para motivarte y alcanzar tus objetivos.",
            imgRes = R.drawable
        ),
        Days(
            descripcionDay = "Mantén una rutina de sueño consistente para mejorar tu salud y bienestar.",
            imgRes = R.drawable
        ),
        Days(
            descripcionDay = "Busca maneras de reducir tu impacto en el medio ambiente y ser más sostenible.",
            imgRes = R.drawable
        ),
        Days(
            descripcionDay = "Dedica tiempo a la reflexión y la introspección para entender tus emociones y pensamientos.",
            imgRes = R.drawable
        )
    )
}
