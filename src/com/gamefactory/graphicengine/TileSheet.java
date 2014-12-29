/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamefactory.graphicengine;

import com.gamefactory.assets.types.TileAsset;
import com.gamefactory.services.ServiceLocator;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author scalpa
 */
public class TileSheet {

    BufferedImage im;

    public TileSheet(String name) {
        im = loadTileSheet(name);
    }

    private BufferedImage loadTileSheet(String name) {
        final TileAsset tileAsset = (TileAsset) ServiceLocator.getAssetManager().getAsset("tiles", name);

        try {
            return ImageIO.read(new ByteArrayInputStream(tileAsset.getPixels()));
        } catch (IOException ex) {
            throw new RuntimeException("Erreur lors du chargement de la TileSheet : " + name);
        }
    }
    
    public BufferedImage loadTile() {
        return im.getSubimage(0, 0, 32, 32);
    }

}
