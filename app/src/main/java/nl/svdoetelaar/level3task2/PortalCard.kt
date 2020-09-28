package nl.svdoetelaar.level3task2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PortalCard(
    var title: String,
    var url: String
) : Parcelable