package com.example.API;

import com.example.data.TeamEntity;
import com.google.gson.annotations.SerializedName;
/*
"idTeam":"133604",
"idSoccerXML":"9",
"idAPIfootball":"42",
"intLoved":"2",
"strTeam":"Arsenal",
"strTeamShort":"Ars",
"strAlternate":"Gunners, Arsenal Football Club, AFC",
"intFormedYear":"1892",
"strSport":"Soccer",
"strLeague":"English Premier League",
"idLeague":"4328",
"strDivision":null,
"strManager":"",
"strStadium":"Emirates Stadium",
"strKeywords":"Gunners, Gooners",
"strRSS":"https://www.allarsenal.com/feed/",
"strStadiumThumb":"https://www.thesportsdb.com/images/media/team/stadium/qpuxrr1419371354.jpg",
"strStadiumDescription":"The Emirates Stadium (known as Ashburton Grove prior to sponsorship, and as Arsenal Stadium for UEFA competitions) is a football stadium in Holloway, London, England, and the home of Arsenal. With a capacity of 60,704 it is the fourth-largest football stadium in England after Wembley Stadium, Old Trafford and Tottenham Hotspur Stadium. In 1997, Arsenal explored the possibility of relocating to a new stadium, having been denied planning permission by Islington Council to expand its home stadium, Highbury. After considering various options (including purchasing Wembley Stadium), the club bought an industrial and waste disposal estate in Ashburton Grove in 2000. A year later, they received the council's approval to build a stadium on the site; manager Arsène Wenger described this as the "biggest decision in Arsenal's history" since the board appointed Herbert Chapman. Relocation began in 2002, but financial difficulties delayed work until February 2004. Emirates was later announced as the main sponsor for the stadium. The entire stadium project was completed in 2006 at a cost of £390 million. The club's former stadium was redeveloped as Highbury Square, an apartment complex. The stadium has undergone a process of "Arsenalisation" since 2009 with the aim of restoring Arsenal's heritage and history. The stadium has hosted international fixtures and music concerts.",
"strStadiumLocation":"Holloway, London",
"intStadiumCapacity":"60338",
"strWebsite":"www.arsenal.com",
"strFacebook":"www.facebook.com/Arsenal",
"strTwitter":"twitter.com/arsenal",
"strInstagram":"instagram.com/arsenal",
"strDescriptionEN":"Arsenal Football Club is a professional football club based in Islington, London, England, that plays in the Premier League, the top flight of English football. The club has won 13 League titles, a record 13 FA Cups, 2 League Cups, 15 FA Community Shields, 1 League Centenary Trophy, 1 UEFA Cup Winners' Cup and 1 Inter-Cities Fairs Cup. Arsenal was the first club from the South of England to join The Football League, in 1893, and they reached the First Division in 1904. Relegated only once, in 1913, they continue the longest streak in the top division, and have won the second-most top-flight matches in English football history. In the 1930s, Arsenal won five League Championships and two FA Cups, and another FA Cup and two Championships after the war. In 1970–71, they won their first League and FA Cup Double. Between 1989 and 2005, they won five League titles and five FA Cups, including two more Doubles. They completed the 20th century with the highest average league position. Herbert Chapman won Arsenal's first national trophies, but died prematurely. He helped introduce the WM formation, floodlights, and shirt numbers, and added the white sleeves and brighter red to the club's kit. Arsène Wenger was the longest-serving manager and won the most trophies. He won a record 7 FA Cups, and his title-winning team set an English record for the longest top-flight unbeaten league run at 49 games between 2003 and 2004, receiving the nickname The Invincibles. In 1886, Woolwich munitions workers founded the club as Dial Square. In 1913, the club crossed the city to Arsenal Stadium in Highbury, becoming close neighbours of Tottenham Hotspur, and creating the North London derby. In 2006, they moved to the nearby Emirates Stadium. In terms of revenue, Arsenal is the ninth highest-earning football club in the world, earned €487.6m in 2016–17 season. Based on social media activity from 2014 to 2015, Arsenal's fanbase is the fifth largest in the world. In 2018, Forbes estimated the club was the third most valuable in England, with the club being worth $2.24 billion.",
"strDescriptionDE":"Der FC Arsenal (offiziell: Arsenal Football Club) – auch bekannt als (The) Arsenal, (The) Gunners (deutsche Übersetzung: „Schützen“ oder „Kanoniere“) oder im deutschen Sprachraum auch Arsenal London genannt – ist ein 1886 gegründeter Fußballverein aus dem Ortsteil Holloway des Nordlondoner Bezirks Islington. Mit 13 englischen Meisterschaften und elf FA-Pokalsiegen zählt der Klub zu den erfolgreichsten englischen Fußballvereinen.Erst über 40 Jahre nach der Gründung gewann Arsenal mit fünf Ligatiteln und zwei FA Cups in den 1930er Jahren seine ersten bedeutenden Titel. Der nächste Meilenstein war in der Saison 1970/71 der Gewinn des zweiten englischen „Doubles“ im 20. Jahrhundert. In den vergangenen 20 Jahren etablierte sich Arsenal endgültig als einer der erfolgreichsten englischen Fußballvereine, und beim Gewinn zweier weiterer Doubles zu Beginn des 21. Jahrhunderts blieb die Mannschaft in der Ligasaison 2003/04 als zweite in der englischen Fußballgeschichte ungeschlagen. Zunehmende europäische Ambitionen unterstrich der Verein in der Spielzeit 2005/06, als Arsenal als erster Londoner Verein das Finale der Champions League erreichte.",
"strDescriptionFR":null,
"strDescriptionCN":null,
"strDescriptionIT":"L'Arsenal Football Club, noto semplicemente come Arsenal, è una società calcistica inglese con sede a Londra, più precisamente nel quartiere di Holloway, nel borgo di Islington.[3] Fondato nel 1886, è uno dei quattordici club che rappresentano la città di Londra a livello professionistico,[4] nonché uno dei più antichi del Paese. Milita nella massima serie del calcio inglese ininterrottamente dal 1919-1920, risultando quindi la squadra da più tempo presente in First Division/Premier League. È la prima squadra della capitale del Regno Unito per successi sportivi e, in ambito federale, la terza dopo Manchester United e Liverpool, essendosi aggiudicata nel corso della sua storia tredici campionati inglesi, dodici FA Cup (record di vittorie, condiviso con il Manchester United), due League Cup e quattordici Community Shield (una condivisa),[5] mentre in ambito internazionale ha conquistato una Coppa delle Coppe ed una Coppa delle Fiere. Inoltre è una delle tredici squadre che hanno raggiunto le finali di tutte le tre principali competizioni gestite dalla UEFA: Champions League (2005-2006), Coppa UEFA (1999-2000) e Coppa delle Coppe (1979-1980, 1993-1994 e 1994-1995).[6] I colori sociali, rosso per la maglietta e bianco per i pantaloncini, hanno subìto variazioni più o meno evidenti nel corso degli anni. Anche la sede del club è stata cambiata più volte: inizialmente la squadra giocava a Woolwich, ma nel 1913 si spostò all'Arsenal Stadium, nel quartiere di Highbury; dal 2006 disputa invece le sue partite casalinghe nel nuovo Emirates Stadium. Lo stemma è stato modificato ripetutamente, ma al suo interno è sempre comparso almeno un cannone. Proprio per questo motivo i giocatori ed i tifosi dell'Arsenal sono spesso soprannominati Gunners (in italiano "cannonieri"). L'Arsenal conta su una schiera di tifosi molto nutrita, distribuita in ogni parte del mondo. Nel corso degli anni sono sorte profonde rivalità con i sostenitori di club concittadini, la più sentita delle quali è quella con i seguaci del Tottenham Hotspur, con i quali i Gunners giocano regolarmente il North London derby.[7] L'Arsenal è anche uno dei club più ricchi del mondo, con un patrimonio stimato di 1,3 miliardi di dollari, secondo la rivista Forbes nel 2014, facendone il quinto club più ricco del pianeta e il secondo in Inghilterra.[8]",
"strDescriptionJP":null,
"strDescriptionRU":null,
"strDescriptionES":null,
"strDescriptionPT":null,
"strDescriptionSE":null,
"strDescriptionNL":null,
"strDescriptionHU":null,
"strDescriptionNO":null,
"strDescriptionIL":null,
"strDescriptionPL":null,
"strGender":"Male",
"strCountry":"England",
"strTeamBadge":"https://www.thesportsdb.com/images/media/team/badge/a1af2i1557005128.png",
"strTeamJersey":"https://www.thesportsdb.com/images/media/team/jersey/2019-133604-Jersey.png",
"strTeamLogo":"https://www.thesportsdb.com/images/media/team/logo/q2mxlz1512644512.png",
"strTeamFanart1":"https://www.thesportsdb.com/images/media/team/fanart/xyusxr1419347566.jpg",
"strTeamFanart2":"https://www.thesportsdb.com/images/media/team/fanart/qttspr1419347612.jpg",
"strTeamFanart3":"https://www.thesportsdb.com/images/media/team/fanart/uwssqx1420884450.jpg",
"strTeamFanart4":"https://www.thesportsdb.com/images/media/team/fanart/qtprsw1420884964.jpg",
"strTeamBanner":"https://www.thesportsdb.com/images/media/team/banner/rtpsrr1419351049.jpg",
"strYoutube":"www.youtube.com/user/ArsenalTour",
"strLocked":"unlocked"
 */
public class RetrofitTeam {
    private static String defaultURL = "";
    @SerializedName("idTeam") private Integer id;

    @SerializedName("strTeam") private String name;

    @SerializedName("strSport") private String sport;

    @SerializedName("strTeamBanner") private String bannerURL;
    @SerializedName("strTwitter") private String twitterUrl;
    @SerializedName("strFacebook") private  String facebookUrl;
    @SerializedName("strInstagram") private String instagramUrl;
    @SerializedName("strDescriptionEN") private String description;

    public RetrofitTeam(int id, String name, String sport, String bannerUrl, String twitterUrl, String facebookUrl, String instagramUrl, String description){
        this.id = id;
        this.name = name;
        this.sport = sport;
        this.bannerURL = bannerUrl;
        this.twitterUrl = twitterUrl;
        this.facebookUrl = facebookUrl;
        this.instagramUrl = instagramUrl;
        this.description = description;
    }
    public TeamEntity toEntity(){
        if(bannerURL == null){
            bannerURL = defaultURL;
        }
        TeamEntity retu =  new TeamEntity(id+"",name, sport, bannerURL+"", twitterUrl, facebookUrl, instagramUrl, description);
        retu.setFavorite(false);

        
        return retu;
    }
}
