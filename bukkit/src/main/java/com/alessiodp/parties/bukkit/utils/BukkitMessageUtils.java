package com.alessiodp.parties.bukkit.utils;

import com.alessiodp.parties.bukkit.addons.external.PlaceholderAPIHandler;
import com.alessiodp.parties.common.PartiesPlugin;
import com.alessiodp.parties.common.parties.objects.PartyImpl;
import com.alessiodp.parties.common.players.objects.PartyPlayerImpl;
import com.alessiodp.parties.common.utils.MessageUtils;

public class BukkitMessageUtils extends MessageUtils {
	
	public BukkitMessageUtils(PartiesPlugin plugin) {
		super(plugin);
	}
	
	@Override
	public String convertPlaceholders(String message, PartyPlayerImpl player, PartyImpl party, String emptyPlaceholder) {
		String ret = super.convertPlaceholders(message, player, party, emptyPlaceholder);
		// PlaceholderAPI
		if (player != null) {
			ret = PlaceholderAPIHandler.getPlaceholders(player.getPlayerUUID(), ret);
		}
		return ret;
	}
	
	@Override
	public String convertRawPlaceholder(String placeholder, PartyPlayerImpl player, PartyImpl party, String emptyPlaceholder) {
		String ret = super.convertRawPlaceholder(placeholder, player, party, emptyPlaceholder);
		// PlaceholderAPI
		if (ret == null && player != null)
			ret = PlaceholderAPIHandler.formatRawPlaceholder(player.getPlayerUUID(), "%" + placeholder + "%");
		return ret;
	}
}
