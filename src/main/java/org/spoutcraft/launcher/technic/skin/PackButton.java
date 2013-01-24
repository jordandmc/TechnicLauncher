/*
 * This file is part of Spoutcraft.
 *
 * Copyright (c) 2011-2012, Spout LLC <http://www.spout.org/>
 * Spoutcraft is licensed under the Spout License Version 1.
 *
 * Spoutcraft is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the Spout License Version 1.
 *
 * Spoutcraft is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the Spout License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spoutcraft.launcher.technic.skin;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.spoutcraft.launcher.technic.ModpackInfo;
import org.spoutcraft.launcher.util.ImageUtils;

public class PackButton {

	private final BufferedImage image;
	private final ImageIcon background;
	private final Image icon;
	private final ModpackInfo info;
	
	public PackButton(ModpackInfo info) throws IOException {
		this.info = info;
		image = info.getImg();
		// Fix magic numbers, frame height and width
		background = new ImageIcon(info.getBackground().getScaledInstance(880, 520, Image.SCALE_SMOOTH));
		icon = info.getIcon();
	}

	public ImageIcon getBackground() {
		return background;
	}

	public Image getIcon() {
		return icon;
	}

	public JLabel createButton(int x, int y, int width, int height) {
		JLabel button = new JLabel();
		button.setBounds(x, y, width, height);
		button.setIcon(new ImageIcon(ImageUtils.scaleImage(image, width, height)));
		return button;
	}

	public void assignButton(JLabel button, int x, int y, int width, int height) {
		button.setBounds(x, y, width, height);
		button.setIcon(new ImageIcon(ImageUtils.scaleImage(image, width, height)));
	}

	public ModpackInfo getModpackInfo() {
		return info;
	}
}
