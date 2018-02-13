

package org.usfirst.frc.team6731.robot.subsystems;
import net.sourceforge.jpcap.capture.*;
import net.sourceforge.jpcap.net.*;

public class VisionConnection 
{
  private static final int INFINITE = -1;
  private static final int PACKET_COUNT = 100; 

  // BPF filter for capturing any packet
  private static final String FILTER = "";

  private PacketCapture m_pcap;
  private String m_device;

  public VisionConnection() throws Exception {
    // Step 1:  Instantiate Capturing Engine
    m_pcap = new PacketCapture();

    // Step 2:  Check for devices 
    m_device = m_pcap.findDevice();

    // Step 3:  Open Device for Capturing (requires root)
    m_pcap.open(m_device, true);

    // Step 4:  Add a BPF Filter (see tcpdump documentation)
    m_pcap.setFilter(FILTER, true);

    // Step 5:  Register a Listener for Raw Packets
    m_pcap.addRawPacketListener(new RawPacketHandler());

    // Step 6:  Capture Data (max. PACKET_COUNT packets)
    m_pcap.capture(PACKET_COUNT);
  }

  public static void main(String[] args) {
    try {
      VisionConnection example = new VisionConnection();
    } 
	catch(Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
}


class RawPacketHandler implements RawPacketListener 
{
  private static int m_counter = 0;

  public void rawPacketArrived(RawPacket data) {
    m_counter++;
    System.out.println("Packet " + m_counter + "\n" + data + "\n");
  }
}






