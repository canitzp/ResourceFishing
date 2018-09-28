package de.canitzp.resourcefishing;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
@Mod(modid = ResourceFishing.MODID, name = ResourceFishing.MODNAME, version = ResourceFishing.MODVERSION)
public class ResourceFishing{
    
    public static final String MODID = "resourcefishing";
    public static final String MODNAME = "ResourceFishing";
    public static final String MODVERSION = "@Version@";
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        IForgeRegistry<Item> reg = event.getRegistry();
        reg.register(new ItemResourceFish("iron", EnumRarity.COMMON, 50, 1));
    }
    
    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event){
        if(event.getName().equals(LootTableList.GAMEPLAY_FISHING_FISH)){
            LootPool pool = event.getTable().getPool("main");
            ForgeRegistries.ITEMS.getValuesCollection().stream().filter(item -> item instanceof ItemResourceFish).forEach(item ->
                pool.addEntry(new LootEntryItem(item, ((ItemResourceFish) item).getWeight(), ((ItemResourceFish) item).getQuantity(), new LootFunction[0], new LootCondition[0], item.getRegistryName().toString()))
            );
        }
    }
}
