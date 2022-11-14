import earthpy as et
import earthpy.spatial as es
import earthpy.plot as ep
from glob import glob
import numpy as np
import matplotlib.pyplot as plt
from matplotlib.colors import ListedColormap


raster_path = glob(
    "C:/Users/User/Desktop/digital/LC08_L2SP_154032_20210527_20210607_02_T1_SR_B*"
)
raster_path.sort()
rast_arr, meta = es.stack(raster_path, nodata=-9999)

ndvi = es.normalized_diff(rast_arr[4], rast_arr[3])

plot_title = ["Landsat 8 - Normallashtirilgan Vegetatsiya Indeksi (NFI)"]

ep.plot_bands(ndvi, cmap="RdYlGn", cols=1, title=plot_title, vmin=-1, vmax=1)
ep.plot_bands(ndvi, cmap="RdYlGn", cols=1, title=plot_title, vmin=-2, vmax=2)


ndvi_class_bins = [-np.inf, 0, 0.1, 0.25, 0.4, np.inf]
ndvi_landsat_class = np.digitize(ndvi, ndvi_class_bins)

ndvi_landsat_class = np.ma.masked_where(
    np.ma.getmask(ndvi), ndvi_landsat_class
)
np.unique(ndvi_landsat_class)


nbr_colors = ["gray", "y", "yellowgreen", "g", "darkgreen"]
nbr_cmap = ListedColormap(nbr_colors)


ndvi_cat_names = [
    "Vegetatsiya mavjud emas", 
    "Bo'sh maydon",  
    "Past darajali vegetatsiya",  
    "O'rta darajali vegetatsiya",  
    "Yuqori darajali vegetatsiya",  
]


classes = np.unique(ndvi_landsat_class)
classes = classes.tolist()
classes = classes[0:5]

# Plotting the data
fig, ax = plt.subplots(figsize=(12, 12))
im = ax.imshow(ndvi_landsat_class, cmap=nbr_cmap)

ep.draw_legend(im_ax=im, classes=classes, titles=ndvi_cat_names)
ax.set_title(
    "Landsat 2 - Normallashtirilgan Farqli Vegetatsiya Indeksi (NFVI) Sinflari",
    fontsize=14,
)
fig.savefig('full_figure.png')
plt.savefig('full_figure.png')
ax.set_axis_off()

plt.tight_layout()