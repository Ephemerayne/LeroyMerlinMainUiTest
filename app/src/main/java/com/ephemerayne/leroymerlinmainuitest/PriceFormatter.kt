package com.ephemerayne.leroymerlinmainuitest

import java.text.DecimalFormat

fun Double.formatPrice(): String = DecimalFormat("#0.##").format(this)