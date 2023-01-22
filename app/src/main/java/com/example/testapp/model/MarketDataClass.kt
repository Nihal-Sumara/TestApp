package com.example.testapp.model


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class MarketDataClass(
    @SerializedName("markets")
    var markets: ArrayList<Market> = ArrayList(),
    @SerializedName("next")
    var next: String = ""
): Parcelable {

    @Parcelize
    data class Market(
        @SerializedName("base_asset")
        var baseAsset: String = "",
        @SerializedName("change_24h")
        var change24h: Double = 0.0,
        @SerializedName("created_at")
        var createdAt: String = "",
        @SerializedName("exchange_id")
        var exchangeId: String = "",
        @SerializedName("price")
        var price: String? = "",
        @SerializedName("price_unconverted")
        var priceUnconverted: Double = 0.0,
        @SerializedName("quote")
        var quote: Quote = Quote(),
        @SerializedName("quote_asset")
        var quoteAsset: String = "",
        @SerializedName("spread")
        var spread: Double = 0.0,
        @SerializedName("status")
        var status: String = "",
        @SerializedName("symbol")
        var symbol: String = "",
        @SerializedName("updated_at")
        var updatedAt: String = "",
        @SerializedName("volume_24h")
        var volume24h: Double = 0.0
    ): Parcelable {
        @Parcelize
        data class Quote(
            @SerializedName("AUD")
            var aUD: AUD = AUD(),
            @SerializedName("CAD")
            var cAD: CAD = CAD(),
            @SerializedName("EUR")
            var eUR: EUR = EUR(),
            @SerializedName("GBP")
            var gBP: GBP = GBP(),
            @SerializedName("JPY")
            var jPY: JPY = JPY(),
            @SerializedName("NZD")
            var nZD: NZD = NZD(),
            @SerializedName("USD")
            var uSD: USD = USD()
        ): Parcelable {
            @Parcelize
            data class AUD(
                @SerializedName("price")
                var price: Double = 0.0,
                @SerializedName("volume_24h")
                var volume24h: Double = 0.0
            ): Parcelable

            @Parcelize
            data class CAD(
                @SerializedName("price")
                var price: Double = 0.0,
                @SerializedName("volume_24h")
                var volume24h: Double = 0.0
            ) : Parcelable

            @Parcelize
            data class EUR(
                @SerializedName("price")
                var price: Double = 0.0,
                @SerializedName("volume_24h")
                var volume24h: Double = 0.0
            ): Parcelable

            @Parcelize
            data class GBP(
                @SerializedName("price")
                var price: Double = 0.0,
                @SerializedName("volume_24h")
                var volume24h: Double = 0.0
            ): Parcelable

            @Parcelize
            data class JPY(
                @SerializedName("price")
                var price: Double = 0.0,
                @SerializedName("volume_24h")
                var volume24h: Double = 0.0
            ): Parcelable

            @Parcelize
            data class NZD(
                @SerializedName("price")
                var price: Double = 0.0,
                @SerializedName("volume_24h")
                var volume24h: Double = 0.0
            ): Parcelable

            @Parcelize
            data class USD(
                @SerializedName("price")
                var price: Double = 0.0,
                @SerializedName("volume_24h")
                var volume24h: Double = 0.0
            ): Parcelable
        }
    }
}