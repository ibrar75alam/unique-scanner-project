const API_URL = "http://localhost:8080/api/scanners/generate";

export const generateScanner = async () => {
  const response = await fetch(API_URL, {
    method: "POST"
  });

  if (!response.ok) {
    throw new Error("Failed to generate scanner");
  }

  return response.json();
};
