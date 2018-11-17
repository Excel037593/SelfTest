package me.varmetek.oldenchant.listener;

import me.varmetek.oldenchant.OldEnchantPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.*;

public class EnchantListener implements Listener
{
  private OldEnchantPlugin plugin;
  private Set<UUID> resetLock = new HashSet<>();
  private Map<UUID,Integer> debt = new HashMap<>();
  public EnchantListener(OldEnchantPlugin plugin){
    this.plugin = plugin;
  }

  @EventHandler
  public void clickEvent(InventoryClickEvent ev){
    if(ev.getClickedInventory()== null
      || ev.getClickedInventory().getType() != InventoryType.ENCHANTING) return;

    resetLock.remove(ev.getWhoClicked().getUniqueId());

  }

  @EventHandler
  public void invCloseEvent(InventoryCloseEvent ev){
    resetLock.remove(ev.getPlayer().getUniqueId());
  }


  @EventHandler
  public void logout(PlayerQuitEvent ev){
    resetLock.remove(ev.getPlayer().getUniqueId());
  }


  @EventHandler
  public void kick(PlayerKickEvent ev){
    resetLock.remove(ev.getPlayer().getUniqueId());
  }




  }


}
