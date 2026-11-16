package io.github.iamwilmar.resonanceport;

// What identifies this game in the user's files: the rest of the start screen is the same in every port.
// Lo que distingue a este juego en los archivos del usuario: el resto de la pantalla de inicio es igual en cada port.
final class Game {
    static final String NAME = "Final Fantasy Resonance";
    static final long APP_ID = 0x0100606026F12000L;
    // Versions are recognised by the build ID of the ExeFS main (bytes 0x40-0x53 of the NSO header). KNOWN_BUILDS:
    // {build ID, version, size of VERSION_FILE in that version's RomFS or null}. STRICT_VERSION: only those builds
    // (ports with address-specific patches); otherwise any build of the game is accepted with a notice.
    static final String VERSION = "1.0.1";
    static final String BUILD_ID = "84e182f72ee1da4f477804bd05b54c1500000000";
    static final String[][] KNOWN_BUILDS = {{"84e182f72ee1da4f477804bd05b54c1500000000", "1.0.1", "12382627"}};
    static final boolean STRICT_VERSION = false;
    static final String VERSION_FILE = "FFRS/Content/Paks/FFRS-Switch.utoc";  // relative to the RomFS root (null: not checked)
    static final String ROMFS_MARKER = "UECommandLine.txt";  // relative to the RomFS root
    static final String UPDATE_MARKER = null;  // only present with the update applied (null: not checked)
    static final String DLC_MARKER = null;  // in the root of each DLC RomFS (null: game without DLC)

    private Game() {}
}
