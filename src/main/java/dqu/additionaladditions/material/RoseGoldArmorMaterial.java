package dqu.additionaladditions.material;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class RoseGoldArmorMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = {264, 384, 360, 312};
    private static final int[] PROTECTION_VALUES = {2, 6, 7, 2};

    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getIndex()];
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getIndex()];
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_GOLD;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(Items.COPPER_INGOT);
    }

    @Override
    public String getName() {
        return "rose_gold";
    }

    @Override
    public float getToughness() {
        return 1.0F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0F;
    }

    @Override
    public int getEnchantmentValue() {
        return 17;
    }

    @Override
    public String toString() {
        return "ROSE_GOLD";
    }
}
