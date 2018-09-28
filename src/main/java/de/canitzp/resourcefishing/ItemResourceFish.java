package de.canitzp.resourcefishing;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemResourceFish extends Item{
    
    private EnumRarity rarity;
    private int weight, quantity;
    
    public ItemResourceFish(String name, EnumRarity rarity, int weight, int quantity){
        this.rarity = rarity;
        this.weight = weight;
        this.quantity = quantity;
        this.setRegistryName(new ResourceLocation(ResourceFishing.MODID, "fish_" + name));
        this.setTranslationKey(this.getRegistryName().toString());
    }
    
    @Override
    public EnumRarity getRarity(ItemStack stack){
        return this.rarity;
    }
    
    public int getWeight(){
        return weight;
    }
    
    public int getQuantity(){
        return quantity;
    }
}
