package com.example.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_teams_table")
class TeamEntity(
    @PrimaryKey @ColumnInfo(name = "id_team") val id: String,
    @ColumnInfo(name="strTeam") val name:String,
    @ColumnInfo(name="strSport") val sport:String,
    @ColumnInfo(name="strTeamBanner") val bannerURL:String,
    @ColumnInfo(name="strTwitter") val twitterUrl:String?,
@ColumnInfo(name="strFacebook") val facebookUrl:String?,
@ColumnInfo(name="strInstagram") val instagramUrl:String?,
    @ColumnInfo(name="strDescriptionEN") val description:String?

) {
    public var isFavorite = true;

    override fun toString(): String {
        return "id:$id, team:$name, sport:$sport, banner:$bannerURL";
    }

}