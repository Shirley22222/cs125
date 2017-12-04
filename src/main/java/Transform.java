/**
 * A class that runs implements several simple transformations on 2D image arrays.
 * <p>
 * This file contains stub code for your image transformation methods that are called by the main
 * class. You will do your work for this MP in this file.
 * <p>
 * Note that you can make several assumptions about the images passed to your functions, both by the
 * web front end and by our testing harness:
 * <ul>
 * <li>You will not be passed empty images.</li>
 * <li>All images will have even width and height.</li>
 * </ul>
 *
 * @see <a href="https://cs125.cs.illinois.edu/MP/4/">MP4 Documentation</a>
 */
public class Transform {

    /**
     * Default amount to shift an image's position. Not used by the testing suite, so feel free to
     * change this value.
     */
    public static final int DEFAULT_POSITION_SHIFT = 16;

    /**
     * Pixel value to use as filler when you don't have any valid data. All white with complete
     * transparency. DO NOT CHANGE THIS VALUE: the testing suite relies on it.
     */
    public static final int FILL_VALUE = 0x00FFFFFF;

    /**
     * Shift the image left by the specified amount.
     * <p>
     * Any pixels shifted in from off screen should be filled with FILL_VALUE. This function <i>does
     * not modify the original image</i>.
     *
     * @param originalImage the image to shift to the left
     * @param amount the amount to shift the image to the left
     * @return the shifted image
     */
    public static int[][] shiftLeft(final int[][] originalImage, final int amount) {
        int width = originalImage.length;
        int length = originalImage[0].length;
        int[][] shifted = new int[width][length];
        for (int rowIndex = 0; rowIndex < width; rowIndex++) {
            for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                if (rowIndex + amount > (width - 1)) {
                    shifted[rowIndex][columnIndex] = FILL_VALUE;
                } else {
                    shifted[rowIndex][columnIndex] = originalImage[rowIndex + amount][columnIndex];
                }
            }
        }
        return shifted;
    }

    /*
     * Shift right like above.
     */
    /**
     * Shift the image right by the specified amount.
     * @param originalImage the image to shift to the right
     * @param amount the amount to shift the image to the right
     * @return the shifted image
     */
    public static int[][] shiftRight(final int[][] originalImage, final int amount) {
        int width = originalImage.length;
        int length = originalImage[0].length;
        int[][] shifted = new int[width][length];
        for (int rowIndex = 0; rowIndex < width; rowIndex++) {
            for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                if (rowIndex - amount < 0) {
                    shifted[rowIndex][columnIndex] = FILL_VALUE;
                } else {
                    shifted[rowIndex][columnIndex] = originalImage[rowIndex - amount][columnIndex];
                }
            }
        }
        return shifted;
    }

    /**
     * Shift up like above.
     * @param originalImage the image to shift up
     * @param amount the amount to shift the image up
     * @return the shifted image
     */
    public static int[][] shiftUp(final int[][] originalImage, final int amount) {
        int width = originalImage.length;
        int length = originalImage[0].length;
        int[][] shifted = new int[width][length];
        for (int rowIndex = 0; rowIndex < width; rowIndex++) {
            for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                if (columnIndex + amount > (length - 1)) {
                    shifted[rowIndex][columnIndex] = FILL_VALUE;
                } else {
                    shifted[rowIndex][columnIndex] = originalImage[rowIndex][columnIndex + amount];
                }
            }
        }
        return shifted;
    }

    /**
     * Shift down like above.
     * @param originalImage the image to shift down
     * @param amount the amount to shift the image down
     * @return the shifted image
     */
    public static int[][] shiftDown(final int[][] originalImage, final int amount) {

        int width = originalImage.length;
        int length = originalImage[0].length;
        int[][] shifted = new int[width][length];
        for (int rowIndex = 0; rowIndex < width; rowIndex++) {
            for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                if (columnIndex - amount < 0) {
                    shifted[rowIndex][columnIndex] = FILL_VALUE;
                } else {
                    shifted[rowIndex][columnIndex] = originalImage[rowIndex][columnIndex - amount];
                }
            }
        }
        return shifted;
    }

    /**
     * Rotate the image left by 90 degrees around its center.
     * <p>
     * Any pixels rotated in from off screen should be filled with FILL_VALUE. This function <i>does
     * not modify the original image</i>.
     *
     * @param originalImage the image to rotate left 90 degrees
     * @return the rotated image
     */
    public static int[][] rotateLeft(final int[][] originalImage) {
        int width = originalImage.length;
        int length = originalImage[0].length;
        int[][] newImage = new int[length][width];
        for (int rowIndex = 0; rowIndex < length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < width; columnIndex++) {
                newImage[rowIndex][columnIndex] =
                        originalImage[width - 1 - columnIndex][rowIndex];
            }
        }
        int[][] rotated = new int[width][length];
        if (length >= width) {
            for (int rowIndex = 0; rowIndex < width; rowIndex++) {
                for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                    int part = (length - width) / 2;
                    if (columnIndex >= part && columnIndex < part + width) {
                        rotated[rowIndex][columnIndex] =
                                newImage[part + rowIndex][columnIndex - part];
                    } else {
                        rotated[rowIndex][columnIndex] = FILL_VALUE;
                    }
                }
            }
        } else {
            for (int rowIndex = 0; rowIndex < width; rowIndex++) {
                for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                    int part = (width - length) / 2;
                    if (rowIndex >= part && rowIndex < part + length) {
                        rotated[rowIndex][columnIndex] =
                                newImage[rowIndex - part][part + columnIndex];
                    } else {
                        rotated[rowIndex][columnIndex] = FILL_VALUE;
                    }
                }
            }
        }
        return rotated;
    }

    /*
     * Rotate the image right like above.
     */
    /**
     * Rotate the image right by 90 degrees around its center.
     * @param originalImage the image to rotate right 90 degrees
     * @return the rotated image
     */
    public static int[][] rotateRight(final int[][] originalImage) {

        int width = originalImage.length;
        int length = originalImage[0].length;
        int[][] newImage = new int[length][width];
        for (int rowIndex = 0; rowIndex < length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < width; columnIndex++) {

                newImage[rowIndex][columnIndex] =
                        originalImage[columnIndex][length - 1 - rowIndex];
            }
        }
        int[][] rotated = new int[width][length];
        if (length >= width) {
            for (int rowIndex = 0; rowIndex < width; rowIndex++) {
                for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                    int part = (length - width) / 2;
                    if (columnIndex >= part && columnIndex < part + width) {
                        rotated[rowIndex][columnIndex] =
                                newImage[part + rowIndex][columnIndex - part];
                    } else {
                        rotated[rowIndex][columnIndex] = FILL_VALUE;
                    }
                }
            }
        } else {
            for (int rowIndex = 0; rowIndex < width; rowIndex++) {
                for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                    int part = (width - length) / 2;
                    if (rowIndex >= part && rowIndex < part + length) {
                        rotated[rowIndex][columnIndex] =
                                newImage[rowIndex - part][part + columnIndex];
                    } else {
                        rotated[rowIndex][columnIndex] = FILL_VALUE;
                    }
                }
            }
        }
        return rotated;
    }

    /*
     * Flip the image on the vertical axis across its center.
     */
    /**
     * Flip the image vertically.
     * @param originalImage the image to flip vertically
     * @return the flipped image
     */
    public static int[][] flipVertical(final int[][] originalImage) {
        int width = originalImage.length;
        int length = originalImage[0].length;
        int[][] flipped = new int[width][length];
        for (int rowIndex = 0; rowIndex < width; rowIndex++) {
            for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                flipped[rowIndex][columnIndex] = originalImage[rowIndex][length - 1 - columnIndex];
            }
        }
        return flipped;
    }

    /*
     * Flip the image on the horizontal axis across its center.
     */
    /**
     * Flip the image horizontally.
     * @param originalImage the image to flip horizontally
     * @return the flipped image
     */
    public static int[][] flipHorizontal(final int[][] originalImage) {
        int width = originalImage.length;
        int length = originalImage[0].length;
        int[][] flipped = new int[width][length];
        for (int rowIndex = 0; rowIndex < width; rowIndex++) {
            for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                flipped[rowIndex][columnIndex] = originalImage[width - 1 - rowIndex][columnIndex];
            }
        }
        return flipped;
    }

    /**
     * Default amount to shift colors by. Not used by the testing suite, so feel free to change this
     * value.
     */
    public static final int DEFAULT_COLOR_SHIFT = 32;

    /**
     * shift1 number.
     */
    public static final int SHIFT_1 = 24;

    /**
     * shift2 number.
     */
    public static final int SHIFT_2 = 16;

    /**
     * shift3 number.
     */
    public static final int SHIFT_3 = 8;

    /**
     * mask number.
     */
    public static final int MASK = 0XFF;

    /**
     * max number.
     */
    public static final int MAX = 255;
    /**
     * Add red to the image.
     * <p>
     * This function <i>does not modify the original image</i>. It should also not generate any new
     * filled pixels.
     *
     * @param originalImage the image to add red to
     * @param amount the amount of red to add
     * @return the recolored image
     */
    public static int[][] moreRed(final int[][] originalImage, final int amount) {
        int width = originalImage.length;
        int length = originalImage[0].length;
        int[][] changed = new int[width][length];
        for (int rowIndex = 0; rowIndex < width; rowIndex++) {
            for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                int element = originalImage[rowIndex][columnIndex];
                int alpha = ((element) >> SHIFT_1) & MASK;
                int blue = ((element) >> SHIFT_2) & MASK;
                int green = ((element) >> SHIFT_3) & MASK;
                int red = element & MASK;
                int newRed = red + amount;
                if (newRed > MAX) {
                    element = (alpha << SHIFT_1) + (blue << SHIFT_2) + (green << SHIFT_3) + MAX;
                } else {
                    element = (alpha << SHIFT_1) + (blue << SHIFT_2) + (green << SHIFT_3) + newRed;
                }
                changed[rowIndex][columnIndex] = element;
            }
        }

        return changed;

    }

    /**
     * Remove red from the image.
     * @param originalImage the image to remove red to
     * @param amount the amount of red to remove
     * @return changed image
     */
    public static int[][] lessRed(final int[][] originalImage, final int amount) {
        int width = originalImage.length;
        int length = originalImage[0].length;
        int[][] changed = new int[width][length];
        for (int rowIndex = 0; rowIndex < width; rowIndex++) {
            for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                int element = originalImage[rowIndex][columnIndex];
                int alpha = ((element) >> SHIFT_1) & MASK;
                int blue = ((element) >> SHIFT_2) & MASK;
                int green = ((element) >> SHIFT_3) & MASK;
                int red = element & MASK;
                int newRed = red - amount;
                if (newRed < 0) {
                    element = (alpha << SHIFT_1) + (blue << SHIFT_2) + (green << SHIFT_3);
                } else {
                    element = (alpha << SHIFT_1) + (blue << SHIFT_2) + (green << SHIFT_3) + newRed;
                }
                changed[rowIndex][columnIndex] = element;
            }
        }

        return changed;
    }

    /**
     * Add green to the image.
     * @param originalImage the image to add green to
     * @param amount the amount of green to add
     * @return changed image
     */
    public static int[][] moreGreen(final int[][] originalImage, final int amount) {
        int width = originalImage.length;
        int length = originalImage[0].length;
        int[][] changed = new int[width][length];
        for (int rowIndex = 0; rowIndex < width; rowIndex++) {
            for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                int element = originalImage[rowIndex][columnIndex];
                int alpha = ((element) >> SHIFT_1) & MASK;
                int blue = ((element) >> SHIFT_2) & MASK;
                int green = ((element) >> SHIFT_3) & MASK;
                int red = element & MASK;
                int newGreen = green + amount;
                if (newGreen > MAX) {
                    element = (alpha << SHIFT_1) + (blue << SHIFT_2) + (MAX << SHIFT_3) + red;
                } else {
                    element = (alpha << SHIFT_1) + (blue << SHIFT_2) + (newGreen << SHIFT_3) + red;
                }
                changed[rowIndex][columnIndex] = element;
            }
        }

        return changed;
    }

    /**
     * Remove green from the image.
     * @param originalImage the image to remove green from
     * @param amount the amount to remove green
     * @return changed image
     */
    public static int[][] lessGreen(final int[][] originalImage, final int amount) {
        int width = originalImage.length;
        int length = originalImage[0].length;
        int[][] changed = new int[width][length];
        for (int rowIndex = 0; rowIndex < width; rowIndex++) {
            for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                int element = originalImage[rowIndex][columnIndex];
                int alpha = ((element) >> SHIFT_1) & MASK;
                int blue = ((element) >> SHIFT_2) & MASK;
                int green = ((element) >> SHIFT_3) & MASK;
                int red = element & MASK;
                int newGreen = green - amount;
                if (newGreen < 0) {
                    element = (alpha << SHIFT_1) + (blue << SHIFT_2) + red;
                } else {
                    element = (alpha << SHIFT_1) + (blue << SHIFT_2) + (newGreen << SHIFT_3) + red;
                }
                changed[rowIndex][columnIndex] = element;
            }
        }

        return changed;
    }

    /**
     * Add blue to the image.
     * @param originalImage the image to add blue to
     * @param amount add blue
     * @return changed image
     */
    public static int[][] moreBlue(final int[][] originalImage, final int amount) {
        int width = originalImage.length;
        int length = originalImage[0].length;
        int[][] changed = new int[width][length];
        for (int rowIndex = 0; rowIndex < width; rowIndex++) {
            for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                int element = originalImage[rowIndex][columnIndex];
                int alpha = ((element) >> SHIFT_1) & MASK;
                int blue = ((element) >> SHIFT_2) & MASK;
                int green = ((element) >> SHIFT_3) & MASK;
                int red = element & MASK;
                int newBlue = blue + amount;
                if (newBlue > MAX) {
                    element = (alpha << SHIFT_1) + (MAX << SHIFT_2) + (green << SHIFT_3) + red;
                } else {
                    element = (alpha << SHIFT_1) + (newBlue << SHIFT_2) + (green << SHIFT_3) + red;
                }
                changed[rowIndex][columnIndex] = element;
            }
        }
        return changed;
    }

    /*
     * Remove blue from the image.
     */
    /**
     *
     * @param originalImage remove blue from the image
     * @param amount remove blue
     * @return changed image
     */
    public static int[][] lessBlue(final int[][] originalImage, final int amount) {
        int width = originalImage.length;
        int length = originalImage[0].length;
        int[][] changed = new int[width][length];
        for (int rowIndex = 0; rowIndex < width; rowIndex++) {
            for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                int element = originalImage[rowIndex][columnIndex];
                int alpha = ((element) >> SHIFT_1) & MASK;
                int blue = ((element) >> SHIFT_2) & MASK;
                int green = ((element) >> SHIFT_3) & MASK;
                int red = element & MASK;
                int newBlue = blue - amount;
                if (newBlue < 0) {
                    element = (alpha << SHIFT_1) + (green << SHIFT_3) + red;
                } else {
                    element = (alpha << SHIFT_1) + (newBlue << SHIFT_2) + (green << SHIFT_3) + red;
                }
                changed[rowIndex][columnIndex] = element;
            }
        }

        return changed;
    }

    /*
     * Increase the image alpha channel.
     */
    /**
     *
     * @param originalImage add alpha to the image
     * @param amount add alpha
     * @return changed image
     */
    public static int[][] moreAlpha(final int[][] originalImage, final int amount) {
        int width = originalImage.length;
        int length = originalImage[0].length;
        int[][] changed = new int[width][length];
        for (int rowIndex = 0; rowIndex < width; rowIndex++) {
            for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                int element = originalImage[rowIndex][columnIndex];
                int alpha = ((element) >> SHIFT_1) & MASK;
                int blue = ((element) >> SHIFT_2) & MASK;
                int green = ((element) >> SHIFT_3) & MASK;
                int red = element & MASK;
                int newAlpha = alpha + amount;
                if (newAlpha > MAX) {
                    element = (MAX << SHIFT_1) + (blue << SHIFT_2) + (green << SHIFT_3) + red;
                } else {
                    element = (newAlpha << SHIFT_1) + (blue << SHIFT_2) + (green << SHIFT_3) + red;
                }
                changed[rowIndex][columnIndex] = element;
            }
        }

        return changed;
    }

    /*
     * Decrease the image alpha channel.
     */
    /**
     *
     * @param originalImage remove alpha form the image
     * @param amount remove alpha
     * @return changed image
     */
    public static int[][] lessAlpha(final int[][] originalImage, final int amount) {
        int width = originalImage.length;
        int length = originalImage[0].length;
        int[][] changed = new int[width][length];
        for (int rowIndex = 0; rowIndex < width; rowIndex++) {
            for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                int element = originalImage[rowIndex][columnIndex];
                int alpha = ((element) >> SHIFT_1) & MASK;
                int blue = ((element) >> SHIFT_2) & MASK;
                int green = ((element) >> SHIFT_3) & MASK;
                int red = element & MASK;
                int newAlpha = alpha - amount;
                if (newAlpha < 0) {
                    element = (blue << SHIFT_2) + (green << SHIFT_3) + red;
                } else {
                    element = (newAlpha << SHIFT_1) + (blue << SHIFT_2) + (green << SHIFT_3) + red;
                }
                changed[rowIndex][columnIndex] = element;
            }
        }

        return changed;
    }

    /**
     * The default resize factor. Not used by the testing suite, so feel free to change this value.
     */
    public static final int DEFAULT_RESIZE_AMOUNT = 2;

    /**
     * Shrink in the vertical axis around the image center.
     * <p>
     * An amount of 2 will result in an image that is half its original height. An amount of 3 will
     * result in an image that's a third of its original height. Any pixels shrunk in from off
     * screen should be filled with FILL_VALUE. This function <i>does not modify the original
     * image</i>.
     *
     * @param originalImage the image to shrink
     * @param amount the factor by which the image's height is reduced
     * @return the shrunken image
     */
    public static int[][] shrinkVertical(final int[][] originalImage, final int amount) {
        return null;
    }

    /*
     * Expand in the vertical axis around the image center.
     */
    /**
     *
     * @param originalImage expand vertically the image
     * @param amount the factor by which the image's height is added
     * @return changed image
     */

    public static int[][] expandVertical(final int[][] originalImage, final int amount) {

        int width = originalImage.length;
        int length = originalImage[0].length;
        int[][] changed = new int[width][length * amount];
        for (int columnIndex = 0; columnIndex < length; columnIndex++) {
            for (int rowIndex = 0; rowIndex < width; rowIndex++) {
                for (int x = 1; x <= amount; x++) {
                    changed[rowIndex][(columnIndex + 1) * amount - x] =
                            originalImage[rowIndex][columnIndex];
                }

            }
        }
        int[][] finalChanged = new int[width][length];
        for (int rowIndex = 0; rowIndex < width; rowIndex++) {
            for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                finalChanged[rowIndex][columnIndex] =
                        changed[rowIndex][(changed[0].length - length) / 2 + columnIndex];
            }
        }
        return finalChanged;
    }

    /*
     * Shrink in the horizontal axis around the image center.
     */
    /**
     *
     * @param originalImage shrink the image horizontally
     * @param amount the factor to expand
     * @return changed image
     */
    public static int[][] shrinkHorizontal(final int[][] originalImage, final int amount) {
        return null;
    }

    /*
     * Expand in the horizontal axis around the image center.
     */
    /**
     *
     * @param originalImage expand the image horizontally
     * @param amount the factor to expand
     * @return changed image
     */
    public static int[][] expandHorizontal(final int[][] originalImage, final int amount) {
        int width = originalImage.length;
        int length = originalImage[0].length;
        int[][] changed = new int[width * amount][length];
        for (int columnIndex = 0; columnIndex < length; columnIndex++) {
            for (int rowIndex = 0; rowIndex < width; rowIndex++) {
                for (int x = 1; x <= amount; x++) {
                    changed[(rowIndex + 1) * amount - x][columnIndex] =
                            originalImage[rowIndex][columnIndex];
                }

            }
        }
        int[][] finalChanged = new int[width][length];
        for (int rowIndex = 0; rowIndex < width; rowIndex++) {
            for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                finalChanged[rowIndex][columnIndex] =
                        changed[(changed.length - width) / 2 + rowIndex][columnIndex];
            }
        }
        return finalChanged;
    }

    /**
     * Remove a green screen mask from an image.
     * <p>
     * This function should remove primarily green pixels from an image and replace them with
     * transparent pixels (FILL_VALUE), allowing you to achieve a green screen effect. Obviously
     * this function will destroy pixels, but it <i>does not modify the original image</i>.
     * <p>
     * While this function is tested by the test suite, only extreme edge cases are used. Getting it
     * work work will with real green screen images is left as a challenge for you.
     *
     * @param originalImage the image to remove a green screen from
     * @return the image with the green screen removed
     */
    public static int[][] greenScreen(final int[][] originalImage) {
        int width = originalImage.length;
        int length = originalImage[0].length;
        int[][] changed = new int[width][length];
        for (int rowIndex = 0; rowIndex < width; rowIndex++) {
            for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                int element = originalImage[rowIndex][columnIndex];
                int alpha = ((element) >> SHIFT_1) & MASK;
                int blue = ((element) >> SHIFT_2) & MASK;
                int green = ((element) >> SHIFT_3) & MASK;
                int red = element & MASK;
                if (red == 0 && blue == 0 && green == MAX && alpha == MAX) {
                    changed[rowIndex][columnIndex] = FILL_VALUE;
                } else {
                    changed[rowIndex][columnIndex] = element;
                }
            }
        }
        return changed;
    }

    /**
     * A wild and mysterious image transform.
     * <p>
     * You are free to implement this in any way you want. It is not tested rigorously by the test
     * suite, but it should do something (change the original image) and <i>not modify the original
     * image</i>.
     * <p>
     * Call this function mystery. It should take only the original image as a single argument and
     * return a modified image.
     *
     * @param originalImage the image to perform a strange and interesting transform on
     * @return the image transformed in wooly and frightening ways
     */
    public static int[][] mystery(final int[][] originalImage) {
        int width = originalImage.length;
        int length = originalImage[0].length;
        int[][] shifted = new int[width][length];
        for (int rowIndex = 0; rowIndex < width; rowIndex++) {
            for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                shifted[rowIndex][columnIndex] = 0x00000000;
            }
        }
        return shifted;
    }

}

//Eunsik Na

