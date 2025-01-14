package eu.pb4.graves.config.data;

import eu.pb4.graves.grave.GravesLookType;
import eu.pb4.graves.grave.GravesXPCalculation;
import eu.pb4.graves.other.GraveUtils;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallBlock;
import net.minecraft.block.enums.WallShape;

import java.util.*;

public class ConfigData extends VersionedConfigData implements Cloneable {
    public String _comment = "Before changing anything, see https://github.com/Patbox/UniversalGraves#configuration";

    public String graveStyle = GravesLookType.PLAYER_HEAD.name;
    public String presetHeadLockedTexture = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjdjYWI1NmM4MmNiODFiZGI5OTc5YTQ2NGJjOWQzYmEzZTY3MjJiYTEyMmNmNmM1Mjg3MzAxMGEyYjU5YWVmZSJ9fX0=";
    public String presetHeadUnlockedTexture = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjdjYWI1NmM4MmNiODFiZGI5OTc5YTQ2NGJjOWQzYmEzZTY3MjJiYTEyMmNmNmM1Mjg3MzAxMGEyYjU5YWVmZSJ9fX0=";
    public List<String> customBlockStateLockedStyles = List.of(
            GraveUtils.blockStateToString(Blocks.STONE_BRICK_WALL.getDefaultState().with(WallBlock.NORTH_SHAPE, WallShape.LOW).with(WallBlock.SOUTH_SHAPE, WallShape.LOW).with(WallBlock.UP, true)),
            GraveUtils.blockStateToString(Blocks.STONE_BRICK_WALL.getDefaultState().with(WallBlock.EAST_SHAPE, WallShape.LOW).with(WallBlock.WEST_SHAPE, WallShape.LOW).with(WallBlock.UP, true))
    );

    public List<String> customBlockStateUnlockedStyles = List.of(
            GraveUtils.blockStateToString(Blocks.MOSSY_STONE_BRICK_WALL.getDefaultState().with(WallBlock.NORTH_SHAPE, WallShape.LOW).with(WallBlock.SOUTH_SHAPE, WallShape.LOW).with(WallBlock.UP, true)),
            GraveUtils.blockStateToString(Blocks.MOSSY_STONE_BRICK_WALL.getDefaultState().with(WallBlock.EAST_SHAPE, WallShape.LOW).with(WallBlock.WEST_SHAPE, WallShape.LOW).with(WallBlock.UP, true))
    );

    public List<String> customStyleSignText = getDefaultSign();

    public List<String> customStyleSignProtectedText = getDefaultProtectedSign();

    public int customStyleUpdateRate = 20;

    public boolean isProtected = true;
    public int protectionTime = 300;
    public int breakingTime = 900;
    public boolean breakEmptyGraves = true;

    public String xpStorageType = GravesXPCalculation.VANILLA.name;
    public double xpPercentTypeValue = 100;

    public boolean createFromPvP = true;
    public boolean createInClaims = true;
    public boolean dropItemsAfterExpiring = true;

    public boolean shiftClickTakesItems = true;

    public String graveTitle = "<lang:'text.graves.players_grave':'${player}'>";

    public boolean hologram = true;
    public double hologramOffset = 1.2;
    public List<String> hologramProtectedText = getDefaultProtectedHologram();
    public List<String> hologramText = getDefaultHologram();

    public String guiTitle = "<lang:'text.graves.gui_title':'${player}'>";
    public List<String> guiProtectedText = getDefaultProtectedGui();
    public List<String> guiText = getDefaultGui();

    public List<String> guiProtectedItem = Collections.singletonList("chest");
    public List<String> guiItem = Collections.singletonList("trapped_chest");

    public String messageGraveCreated = "<white><lang:'text.graves.created_at':'<yellow>${position}':'<gray>${world}'>";
    public String messageProtectionEnded = "<red><lang:'text.graves.no_longer_protected':'<gold>${position}':'<white>${world}':'<yellow>${item_count}'>";
    public String messageGraveExpired = "<red><lang:'text.graves.expired':'<gold>${position}':'<white>${world}':'<yellow>${item_count}'>";
    public String messageGraveBroken = "<gray><lang:'text.graves.somebody_broke':'<white>${position}':'<white>${world}':'<white>${item_count}'>";
    public String messageCreationFailed = "<red><lang:'text.graves.creation_failed':'<gold>${position}':'<yellow>${world}'>";
    public String messageCreationFailedPvP = "<red><lang:'text.graves.creation_failed_pvp':'<gold>${position}':'<yellow>${world}'>";
    public String messageCreationFailedClaim = "<red><lang:'text.graves.creation_failed_claim':'<gold>${position}':'<yellow>${world}'>";

    public String neverExpires = "Never";

    public String yearsText = "y";
    public String daysText = "d";
    public String hoursText = "h";
    public String minutesText = "m";
    public String secondsText = "s";

    public Map<String, String> worldNameOverrides = new HashMap<>();



    private static List<String> getDefaultProtectedHologram() {
        List<String> list = new ArrayList<>();

        list.add("<gold><lang:'text.graves.grave_of':'<white>${player}'>");
        list.add("<yellow>${death_cause}");
        list.add("");
        list.add("<gray><lang:'text.graves.items_xp':'<white>${item_count}':'<white>${xp}'>");
        list.add("<blue><lang:'text.graves.protected_time':'<white>${protection_time}'>");
        list.add("<red><lang:'text.graves.break_time':'<white>${break_time}'>");

        return list;
    }

    private static List<String> getDefaultHologram() {
        List<String> list = new ArrayList<>();

        list.add("<gold><lang:'text.graves.grave_of':'<white>${player}'>");
        list.add("<yellow>${death_cause}");
        list.add("");
        list.add("<gray><lang:'text.graves.items_xp':'<white>${item_count}':'<white>${xp}'>");
        list.add("<blue><lang:'text.graves.not_protected'>");
        list.add("<red><lang:'text.graves.break_time':'<white>${break_time}'>");

        return list;
    }

    private static List<String> getDefaultProtectedGui() {
        List<String> list = new ArrayList<>();

        list.add("${position} <gray>(${world})");
        list.add("<yellow>${death_cause}");
        list.add("<gray><lang:'text.graves.items_xp':'<white>${item_count}':'<white>${xp}'>");
        list.add("<blue><lang:'text.graves.protected_time':'<white>${protection_time}'>");
        list.add("<red><lang:'text.graves.break_time':'<white>${break_time}'>");

        return list;
    }

    private static List<String> getDefaultGui() {
        List<String> list = new ArrayList<>();

        list.add("${position} <gray>(${world})");
        list.add("<yellow>${death_cause}");
        list.add("<gray><lang:'text.graves.items_xp':'<white>${item_count}':'<white>${xp}'>");
        list.add("<blue><lang:'text.graves.not_protected'>");
        list.add("<red><lang:'text.graves.break_time':'<white>${break_time}'>");

        return list;
    }

    private static List<String> getDefaultProtectedSign() {
        List<String> list = new ArrayList<>();

        list.add("<white>${player}");
        list.add("<gray><lang:'text.graves.items_xp':'<white>${item_count}':'<white>${xp}'>");
        list.add("<blue><lang:'text.graves.protected_time':''>");
        list.add("<white>${protection_time}");

        return list;
    }

    private static List<String> getDefaultSign() {
        List<String> list = new ArrayList<>();

        list.add("<white>${player}");
        list.add("<gray><lang:'text.graves.items_xp':'<white>${item_count}':'<white>${xp}'>");
        list.add("<red><lang:'text.graves.break_time':''>");
        list.add("<white>${break_time}");

        return list;
    }

    @Override
    public ConfigData clone() {
        try {
            return (ConfigData) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
