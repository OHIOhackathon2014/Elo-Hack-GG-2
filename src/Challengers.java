import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.sun.scenario.effect.impl.sw.java.JSWBlend_ADDPeer;
import constant.QueueType;
import constant.Region;
import dto.League.League;
import dto.Summoner.Summoner;
import main.java.riotapi.RiotApi;
import main.java.riotapi.RiotApiException;
import com.google.gson.*;
import sun.misc.JavaIOAccess;

public class Challengers {

    public static void main (String args[]) {
        Collection<JsonObject> collections = new ArrayList<JsonObject>();
        getChallengerNA(collections);
        //getChallengerEUW(collections);
        //getChallengerKR(collections);


        try {
            FileWriter outFile = new FileWriter("./challengers.json");
            outFile.write(collections.toArray().toString());

        } catch (IOException e) {
            System.out.println("SPEL:ING OS HJAD") ;
        }

        System.out.println(collections);
    }

    public static void getChallengerNA(Collection<JsonObject> collections) {

        RiotApi api = new RiotApi("9b269c05-00ea-46ec-88c0-3a6c7dc88057");
        League challengers = null;
        try {
            challengers = api.getChallengerLeagues(Region.NA, QueueType.RANKED_SOLO_5x5);
        } catch (RiotApiException e) {
            System.out.println("Exception. Unable to get challenger list for NA.");
        }

        for (int i = 0; i < challengers.getEntries().size(); i++) {
            String playerIDorTeam = challengers.getEntries().get(i).getPlayerOrTeamId();
            JsonObject playerID = new JsonObject();
            playerID.addProperty("play id: ", playerIDorTeam);
            collections.add((playerID));
            //System.out.println(playerID);
        }
    }


    public static void getChallengerEUW(Collection<JsonObject> collections) {

        RiotApi api = new RiotApi("60ddd5a6-8e52-4430-a4c4-3f0d2436f2f1");

        League challengers = null;
        try {
            challengers = api.getChallengerLeagues(Region.EUW, QueueType.RANKED_SOLO_5x5);
        } catch (RiotApiException e) {
            System.out.println("Exception. Unable to get challenger list for EUW.");
        }

        for (int i = 0; i < challengers.getEntries().size(); i++) {
            String playerIDorTeam = challengers.getEntries().get(i).getPlayerOrTeamId();
            JsonObject playerID = new JsonObject();
            playerID.addProperty("play id: ", playerIDorTeam);
            collections.add((playerID));
            //System.out.println(playerID);
        }
    }

    public static void getChallengerKR(Collection<JsonObject> collections) {

        RiotApi api = new RiotApi("fd273def-68ff-4754-bf10-b3866983846d3");
        League challengers = null;
        try {
            challengers = api.getChallengerLeagues(Region.KR, QueueType.RANKED_SOLO_5x5);
        } catch (RiotApiException e) {
            System.out.println("Exception. Unable to get challenger list for KR.");
        }

        for (int i = 0; i < challengers.getEntries().size(); i++) {
            String playerIDorTeam = challengers.getEntries().get(i).getPlayerOrTeamId();
            JsonObject playerID = new JsonObject();
            playerID.addProperty("play id: ", playerIDorTeam);
            collections.add((playerID));
            //System.out.println(playerID);
        }
    }
}