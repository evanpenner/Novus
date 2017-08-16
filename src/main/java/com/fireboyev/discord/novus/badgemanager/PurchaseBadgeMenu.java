package com.fireboyev.discord.novus.badgemanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fireboyev.discord.novus.Main;
import com.fireboyev.discord.novus.filestorage.FileManager;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;

public class PurchaseBadgeMenu {
	Member member;
	int page;
	List<HashMap<Integer, BadgeInfo>> pages;
	HashMap<Integer, BadgeInfo> currentPage;
	Message lastMessage;

	public PurchaseBadgeMenu(Member member) {
		pages = new ArrayList<>();
		page = 0;
		List<String> owned = FileManager.openUserFolder(member.getUser()).options.getBadges().getOwned();
		List<BadgeInfo> purchasable = new ArrayList<>();
		for (BadgeInfo info : FileManager.getAllBadges()) {
			if (!owned.contains(info)) {
				purchasable.add(info);
			}
		}
		int totalCount = 0;
		int count = 1;
		HashMap<Integer, BadgeInfo> current = new HashMap<Integer, BadgeInfo>();
		for (BadgeInfo info : purchasable) {
			current.put(count, info);
			count++;
			if (count >= 8 || totalCount >= purchasable.size() - 1) {
				pages.add(current);
				current = new HashMap<Integer, BadgeInfo>();
				count = 1;
			}
			totalCount++;
		}
	}

	public void trigger(Message msg) {

	}

	public void close() {
		Main.getBadgeManager().badgeMenus.remove(member.getUser().getIdLong());

	}
}
